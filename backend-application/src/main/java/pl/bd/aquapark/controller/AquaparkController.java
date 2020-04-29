package pl.bd.aquapark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bd.aquapark.dao.*;
import pl.bd.aquapark.dto.AquaparkAttractionDto;
import pl.bd.aquapark.dto.PriceListItemDto;
import pl.bd.aquapark.repository.AttractionRepository;
import pl.bd.aquapark.repository.GenderRepository;
import pl.bd.aquapark.repository.PriceListRepository;
import pl.bd.aquapark.repository.RoleRepository;
import pl.bd.aquapark.service.*;

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
    AttractionRepository attractionRepository;

    @GetMapping(value = "/genders")
    public ResponseEntity<List<Gender>> getVisit() {
        return ResponseEntity.ok(GetAllService.getAll(genderRepository));
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(GetAllService.getAll(roleRepository));
    }

    @GetMapping(value = "/pricelist")
    public ResponseEntity<List<PriceListItemDto>> getPriceListItems() {
        PriceList priceList = PricingService.getPriceListForDate(priceListRepository, DateService.getCurrentDay());
        return ResponseEntity.ok(priceList
            .getPriceListItems()
            .stream()
                .map(PriceListItemDto::fromPriceListItem)
                .collect(Collectors.toList())
        );
    }
    @GetMapping(value = "/attractions")
    public ResponseEntity<List<AquaparkAttractionDto>> getAttractions(@RequestParam(required = false) String name) {
        List<AquaparkAttraction> aquaparkAttractions = GetAllService.getAll(attractionRepository);
        aquaparkAttractions = new FilteringService<>(aquaparkAttractions).contains(name, AquaparkAttraction::getName).getFiltered();
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
}
