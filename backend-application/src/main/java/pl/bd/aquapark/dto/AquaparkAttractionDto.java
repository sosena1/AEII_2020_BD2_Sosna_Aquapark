package pl.bd.aquapark.dto;

import pl.bd.aquapark.dao.AquaparkAttraction;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;
import pl.bd.aquapark.util.DateUtil;

import java.sql.Date;

public
class AquaparkAttractionDto {
    private Long attractionId;
    private Long maxUsers;
    private String name;
    private boolean maintenanceToday;

    public AquaparkAttractionDto(Long attractionId, Long maxUsers, String name, boolean maintenanceToday) {
        this.attractionId = attractionId;
        this.maxUsers = maxUsers;
        this.name = name;
        this.maintenanceToday = maintenanceToday;
    }


    public static AquaparkAttractionDto fromAquaparkAttraction(AquaparkAttraction aquaparkAttraction) {
        long attractionId = aquaparkAttraction.getAttractionId();
        Long maxUsers = aquaparkAttraction.getMaxUsers();
        String name = aquaparkAttraction.getName();
        Date today = DateUtil.getCurrentDay();
        boolean maintenanceToday = aquaparkAttraction.getAquaparkAttractionMaintenances()
                .stream().anyMatch((AquaparkAttractionMaintenance a) -> a.getDate().equals(today));
        return new AquaparkAttractionDto(attractionId, maxUsers, name, maintenanceToday);
    }

    public Long getAttractionId() {
        return this.attractionId;
    }

    public Long getMaxUsers() {
        return this.maxUsers;
    }

    public String getName() {
        return this.name;
    }

    public boolean isMaintenanceToday() {
        return this.maintenanceToday;
    }

    public void setAttractionId(Long attractionId) {
        this.attractionId = attractionId;
    }

    public void setMaxUsers(Long maxUsers) {
        this.maxUsers = maxUsers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaintenanceToday(boolean maintenanceToday) {
        this.maintenanceToday = maintenanceToday;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AquaparkAttractionDto)) return false;
        final AquaparkAttractionDto other = (AquaparkAttractionDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$attractionId = this.getAttractionId();
        final Object other$attractionId = other.getAttractionId();
        if (this$attractionId == null ? other$attractionId != null : !this$attractionId.equals(other$attractionId))
            return false;
        final Object this$maxUsers = this.getMaxUsers();
        final Object other$maxUsers = other.getMaxUsers();
        if (this$maxUsers == null ? other$maxUsers != null : !this$maxUsers.equals(other$maxUsers)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.isMaintenanceToday() != other.isMaintenanceToday()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AquaparkAttractionDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $attractionId = this.getAttractionId();
        result = result * PRIME + ($attractionId == null ? 43 : $attractionId.hashCode());
        final Object $maxUsers = this.getMaxUsers();
        result = result * PRIME + ($maxUsers == null ? 43 : $maxUsers.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + (this.isMaintenanceToday() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "AquaparkAttractionDto(attractionId=" + this.getAttractionId() + ", maxUsers=" + this.getMaxUsers() + ", name=" + this.getName() + ", maintenanceToday=" + this.isMaintenanceToday() + ")";
    }
}
