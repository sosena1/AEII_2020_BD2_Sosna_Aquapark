package pl.bd.aquapark.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bd.aquapark.dao.*;
import pl.bd.aquapark.dto.AquaparkAttractionDto;
import pl.bd.aquapark.repository.AttractionRepository;
import pl.bd.aquapark.repository.GenderRepository;
import pl.bd.aquapark.repository.PriceListRepository;
import pl.bd.aquapark.repository.RoleRepository;
import pl.bd.aquapark.service.DateService;
import pl.bd.aquapark.service.GetAllService;
import pl.bd.aquapark.service.PriceListService;

import java.util.List;
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
    public ResponseEntity<List<PriceListItem>> getPriceListItems() {
        PriceList priceList = PriceListService.getPriceListForDate(priceListRepository, DateService.utilDateToSqlDate(new java.util.Date()));
        return ResponseEntity.ok(priceList.getPriceListItems());
    }

    @GetMapping(value = "/attractions")
    public ResponseEntity<List<AquaparkAttractionDto>> getAttractions() {
        List<AquaparkAttraction> aquaparkAttractions = GetAllService.getAll(attractionRepository);
        return ResponseEntity.ok(
          aquaparkAttractions.stream()
            .map(AquaparkAttractionDto::fromAquaparkAttraction)
            .collect(Collectors.toList())
        );
    }

}
