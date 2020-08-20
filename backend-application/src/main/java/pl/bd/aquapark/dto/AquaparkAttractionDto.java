package pl.bd.aquapark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.bd.aquapark.dao.AquaparkAttraction;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;
import pl.bd.aquapark.util.DateUtil;

import java.sql.Date;

public @Data @AllArgsConstructor
class AquaparkAttractionDto {
    private Long attractionId;
    private Long maxUsers;
    private String name;
    private boolean maintenanceToday;


    public static AquaparkAttractionDto fromAquaparkAttraction(AquaparkAttraction aquaparkAttraction) {
        long attractionId = aquaparkAttraction.getAttractionId();
        Long maxUsers = aquaparkAttraction.getMaxUsers();
        String name = aquaparkAttraction.getName();
        Date today = DateUtil.getCurrentDay();
        boolean maintenanceToday = aquaparkAttraction.getAquaparkAttractionMaintenances()
                .stream().anyMatch((AquaparkAttractionMaintenance a) -> a.getDate().equals(today));
        return new AquaparkAttractionDto(attractionId, maxUsers, name, maintenanceToday);
    }
}
