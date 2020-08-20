package pl.bd.aquapark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;
import pl.bd.aquapark.dao.User;

import java.sql.Date;

public @Data @AllArgsConstructor
class AquaparkMaintenanceDto {
    private Long attractionMaintenanceId;
    private Long attractionId;
    private String maintenanceName;
    private String description;
    private Date date;
    private String employeePesel;
    private String employeeFirstName;
    private String employeeLatName;


    public static AquaparkMaintenanceDto fromAquaparkAttractionMaintenance(AquaparkAttractionMaintenance aam) {
        User user = aam.getEmployee().getUser();
        return new AquaparkMaintenanceDto(
                aam.getAttractionMaintenanceId(),
                aam.getAquaparkAttraction().getAttractionId(),
                aam.getAquaparkAttraction().getName(),
                aam.getDescription(),
                aam.getDate(),
                user.getPesel(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
