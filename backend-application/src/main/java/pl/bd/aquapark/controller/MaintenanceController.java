package pl.bd.aquapark.controller;

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
import pl.bd.aquapark.util.DateUtil;
import pl.bd.aquapark.util.FilteringUtil;
import pl.bd.aquapark.util.GetAllUtil;

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

        List<AquaparkAttractionMaintenance> maintenances = GetAllUtil.getAll(attractionMaintenanceRepository);
        maintenances = new FilteringUtil<>(maintenances)
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
        maintenance.setDate(newEntry.date == null ? DateUtil.getCurrentDay() : newEntry.date);
        maintenance.setDescription(newEntry.description);
        maintenance.setEmployee(newEntry.employeeId == null ? user.getEmployee() : employeeRepository.findById(newEntry.employeeId).get());
        maintenance.setAquaparkAttraction(optionalAquaparkAttraction.get());

        maintenance = attractionMaintenanceRepository.save(maintenance);

        return ResponseEntity.ok(AquaparkMaintenanceDto.fromAquaparkAttractionMaintenance(maintenance));
    }

    public static class NewEntry {
        private Long attractionId;
        private String description;
        private Date date;
        private Long employeeId;

        public NewEntry() {
        }

        public boolean hasRequiredFields() {
            return (date != null) && (employeeId != null);
        }

        public Long getAttractionId() {
            return this.attractionId;
        }

        public String getDescription() {
            return this.description;
        }

        public Date getDate() {
            return this.date;
        }

        public Long getEmployeeId() {
            return this.employeeId;
        }

        public void setAttractionId(Long attractionId) {
            this.attractionId = attractionId;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof NewEntry)) return false;
            final NewEntry other = (NewEntry) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$attractionId = this.getAttractionId();
            final Object other$attractionId = other.getAttractionId();
            if (this$attractionId == null ? other$attractionId != null : !this$attractionId.equals(other$attractionId))
                return false;
            final Object this$description = this.getDescription();
            final Object other$description = other.getDescription();
            if (this$description == null ? other$description != null : !this$description.equals(other$description))
                return false;
            final Object this$date = this.getDate();
            final Object other$date = other.getDate();
            if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
            final Object this$employeeId = this.getEmployeeId();
            final Object other$employeeId = other.getEmployeeId();
            if (this$employeeId == null ? other$employeeId != null : !this$employeeId.equals(other$employeeId))
                return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof NewEntry;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $attractionId = this.getAttractionId();
            result = result * PRIME + ($attractionId == null ? 43 : $attractionId.hashCode());
            final Object $description = this.getDescription();
            result = result * PRIME + ($description == null ? 43 : $description.hashCode());
            final Object $date = this.getDate();
            result = result * PRIME + ($date == null ? 43 : $date.hashCode());
            final Object $employeeId = this.getEmployeeId();
            result = result * PRIME + ($employeeId == null ? 43 : $employeeId.hashCode());
            return result;
        }

        public String toString() {
            return "MaintenanceController.NewEntry(attractionId=" + this.getAttractionId() + ", description=" + this.getDescription() + ", date=" + this.getDate() + ", employeeId=" + this.getEmployeeId() + ")";
        }
    }
}
