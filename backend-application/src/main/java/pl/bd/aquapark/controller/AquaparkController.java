package pl.bd.aquapark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.config.UsernamePasswordAndIdToken;
import pl.bd.aquapark.dao.*;
import pl.bd.aquapark.dto.*;
import pl.bd.aquapark.repository.*;
import pl.bd.aquapark.util.DateUtil;
import pl.bd.aquapark.util.FilteringUtil;
import pl.bd.aquapark.util.GetAllUtil;
import pl.bd.aquapark.util.PricingUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aquapark")
public class AquaparkController {
    @Autowired
    GenderRepository genderRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PriceListRepository priceListRepository;

    @Autowired
    PriceListItemRepository priceListItemRepository;

    @Autowired
    AttractionRepository attractionRepository;

    @Autowired
    ConditionRepository conditionRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/genders")
    public ResponseEntity<List<GenderDto>> getVisit() {
        return ResponseEntity.ok(
                GetAllUtil.getAll(genderRepository)
                        .stream().map(GenderDto::fromGender).collect(Collectors.toList())
        );
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<List<RoleDto>> getRoles() {
        return ResponseEntity.ok(
                GetAllUtil.getAll(roleRepository)
                .stream().map(RoleDto::fromRole).collect(Collectors.toList())
        );
    }

    @GetMapping(value = "/pricelist")
    public ResponseEntity<List<PriceListItemDto>> getPriceListItems() {
        PriceList priceList = PricingUtil.getPriceListForDate(priceListRepository, DateUtil.getCurrentDay());
        return ResponseEntity.ok(priceList
            .getPriceListItems()
            .stream()
                .map(PriceListItemDto::fromPriceListItem)
                .collect(Collectors.toList())
        );
    }
    @GetMapping(value = "/attractions")
    public ResponseEntity<List<AquaparkAttractionDto>> getAttractions(@RequestParam(required = false) String name) {
        List<AquaparkAttraction> aquaparkAttractions = GetAllUtil.getAll(attractionRepository);
        aquaparkAttractions = new FilteringUtil<>(aquaparkAttractions).contains(name, AquaparkAttraction::getName).getFiltered();
        return ResponseEntity.ok(
          aquaparkAttractions.stream()
            .map(AquaparkAttractionDto::fromAquaparkAttraction)
            .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "/attractions/{id}")
    public ResponseEntity<AquaparkAttractionDto> getAttraction(@PathVariable(name = "id") Long id) {
        Optional<AquaparkAttraction> aquaparkAttraction = attractionRepository.findById(id);
        if (aquaparkAttraction.isPresent()) {
            return ResponseEntity.ok(AquaparkAttractionDto.fromAquaparkAttraction(aquaparkAttraction.get()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @PostMapping(value = "/pricelist")
    public ResponseEntity setPriceList(@RequestBody SetPriceListDto setPriceListDto, HttpServletRequest servletRequest) {
        if (servletRequest.getUserPrincipal() == null) { //potrzebny check bo na ten endpoint da się dostać bez logowania
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (!servletRequest.isUserInRole(Roles.PRICELIST_MAINTAINER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<PriceListItem> priceListItems = new ArrayList<>();
        for (SetPriceListDto.SetPriceListItem item : setPriceListDto.getItems()) {
            PriceListItem priceListItem = new PriceListItem();
            Optional<AquaparkAttraction> optionalAquaparkAttraction = attractionRepository.findById(item.getAttractionId());
            if (!optionalAquaparkAttraction.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No attraction with id " + item.getAttractionId());
            }

            Conditions conditions = PricingUtil.getOrCreateCondition(conditionRepository, item.isChildOnly(), item.isSeniorOnly(), item.isWeekendOnly());

            priceListItem.setConditions(conditions);
            priceListItem.setName(item.getName());
            priceListItem.setValue(item.getValue());
            priceListItem.setDescription(item.getDescription());
            priceListItem.setAquaparkAttraction(optionalAquaparkAttraction.get());

            priceListItems.add(priceListItem);
        }

        PriceList priceList = new PriceList();
        priceList.setValidityStartDate(setPriceListDto.getValidityDate());
        UsernamePasswordAndIdToken usernamePasswordAndIdToken = (UsernamePasswordAndIdToken) servletRequest.getUserPrincipal();

        User user = userRepository.findById(usernamePasswordAndIdToken.getUserId()).get();
        priceList.setEmployee(user.getEmployee());

        priceList = priceListRepository.save(priceList);

        for (PriceListItem item : priceListItems) {
            item.setPriceList(priceList);
            priceListItemRepository.save(item);
        }

        return getPriceListItems();
    }
}
