package pl.bd.aquapark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;
import pl.bd.aquapark.dto.AquaparkMaintenanceDto;
import pl.bd.aquapark.repository.AttractionMaintenanceRepository;
import pl.bd.aquapark.service.FilteringService;
import pl.bd.aquapark.service.GetAllService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    AttractionMaintenanceRepository attractionMaintenanceRepository;

    @GetMapping
    public ResponseEntity<List<AquaparkMaintenanceDto>> getMaintenances(
            HttpServletRequest servletRequest,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Date startingDate,
            @RequestParam(required = false) Date endingDate,
            @RequestParam(required = false) Long attractionId
            ) {

        if (!servletRequest.isUserInRole(Roles.MAINTAINER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<AquaparkAttractionMaintenance> maintenances = GetAllService.getAll(attractionMaintenanceRepository);
        maintenances = new FilteringService<>(maintenances)
                .contains(name, (AquaparkAttractionMaintenance a) -> a.getAquaparkAttraction().getName())
                .starts(startingDate, AquaparkAttractionMaintenance::getDate)
                .ends(endingDate, AquaparkAttractionMaintenance::getDate)
                .contains(attractionId, (AquaparkAttractionMaintenance a) -> a.getAquaparkAttraction().getAttractionId())
                .getFiltered();


        return ResponseEntity.ok(maintenances
            .stream()
            .map(AquaparkMaintenanceDto::fromAquaparkAttractionMaintenance)
            .collect(Collectors.toList())
        );

    }
}
