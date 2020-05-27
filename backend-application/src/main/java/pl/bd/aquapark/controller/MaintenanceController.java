package pl.bd.aquapark.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.config.UsernamePasswordAndIdToken;
import pl.bd.aquapark.dao.AquaparkAttraction;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;
import pl.bd.aquapark.dao.User;
import pl.bd.aquapark.dto.AquaparkMaintenanceDto;
import pl.bd.aquapark.repository.AttractionMaintenanceRepository;
import pl.bd.aquapark.repository.AttractionRepository;
import pl.bd.aquapark.repository.EmployeeRepository;
import pl.bd.aquapark.repository.UserRepository;
import pl.bd.aquapark.service.DateService;
import pl.bd.aquapark.service.FilteringService;
import pl.bd.aquapark.service.GetAllService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    AttractionMaintenanceRepository attractionMaintenanceRepository;

    @Autowired
    AttractionRepository attractionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

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

    @PostMapping
    public ResponseEntity createMaintenance(
            HttpServletRequest servletRequest,
            @RequestBody NewEntry newEntry
    ) {

        if (!servletRequest.isUserInRole(Roles.MAINTAINER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (!newEntry.hasRequiredFields()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing fields");
        }

        Optional<AquaparkAttraction> optionalAquaparkAttraction = attractionRepository.findById(newEntry.attractionId);
        if (!optionalAquaparkAttraction.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such attraction");
        }
        //todo perform checks


        UsernamePasswordAndIdToken usernamePasswordAndIdToken = (UsernamePasswordAndIdToken) servletRequest.getUserPrincipal();

        User user = userRepository.findById(usernamePasswordAndIdToken.getUserId()).get();

        AquaparkAttractionMaintenance maintenance = new AquaparkAttractionMaintenance();
        maintenance.setDate(newEntry.date == null ? DateService.getCurrentDay() : newEntry.date);
        maintenance.setDescription(newEntry.description);
        maintenance.setEmployee(newEntry.employeeId == null ? user.getEmployee() : employeeRepository.findById(newEntry.employeeId).get());
        maintenance.setAquaparkAttraction(optionalAquaparkAttraction.get());

        maintenance = attractionMaintenanceRepository.save(maintenance);

        return ResponseEntity.ok(AquaparkMaintenanceDto.fromAquaparkAttractionMaintenance(maintenance));
    }

    public static @Data class NewEntry {
        private Long attractionId;
        private String description;
        private Date date;
        private Long employeeId;

        public boolean hasRequiredFields() {
            return (date != null) && (employeeId != null);
        }

    }
}
