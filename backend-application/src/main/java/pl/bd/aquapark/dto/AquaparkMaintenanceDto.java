package pl.bd.aquapark.dto;

import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;
import pl.bd.aquapark.dao.User;

import java.sql.Date;

public
class AquaparkMaintenanceDto {
    private Long attractionMaintenanceId;
    private Long attractionId;
    private String maintenanceName;
    private String description;
    private Date date;
    private String employeePesel;
    private String employeeFirstName;
    private String employeeLatName;

    public AquaparkMaintenanceDto(Long attractionMaintenanceId, Long attractionId, String maintenanceName, String description, Date date, String employeePesel, String employeeFirstName, String employeeLatName) {
        this.attractionMaintenanceId = attractionMaintenanceId;
        this.attractionId = attractionId;
        this.maintenanceName = maintenanceName;
        this.description = description;
        this.date = date;
        this.employeePesel = employeePesel;
        this.employeeFirstName = employeeFirstName;
        this.employeeLatName = employeeLatName;
    }


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

    public Long getAttractionMaintenanceId() {
        return this.attractionMaintenanceId;
    }

    public Long getAttractionId() {
        return this.attractionId;
    }

    public String getMaintenanceName() {
        return this.maintenanceName;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDate() {
        return this.date;
    }

    public String getEmployeePesel() {
        return this.employeePesel;
    }

    public String getEmployeeFirstName() {
        return this.employeeFirstName;
    }

    public String getEmployeeLatName() {
        return this.employeeLatName;
    }

    public void setAttractionMaintenanceId(Long attractionMaintenanceId) {
        this.attractionMaintenanceId = attractionMaintenanceId;
    }

    public void setAttractionId(Long attractionId) {
        this.attractionId = attractionId;
    }

    public void setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmployeePesel(String employeePesel) {
        this.employeePesel = employeePesel;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public void setEmployeeLatName(String employeeLatName) {
        this.employeeLatName = employeeLatName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AquaparkMaintenanceDto)) return false;
        final AquaparkMaintenanceDto other = (AquaparkMaintenanceDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$attractionMaintenanceId = this.getAttractionMaintenanceId();
        final Object other$attractionMaintenanceId = other.getAttractionMaintenanceId();
        if (this$attractionMaintenanceId == null ? other$attractionMaintenanceId != null : !this$attractionMaintenanceId.equals(other$attractionMaintenanceId))
            return false;
        final Object this$attractionId = this.getAttractionId();
        final Object other$attractionId = other.getAttractionId();
        if (this$attractionId == null ? other$attractionId != null : !this$attractionId.equals(other$attractionId))
            return false;
        final Object this$maintenanceName = this.getMaintenanceName();
        final Object other$maintenanceName = other.getMaintenanceName();
        if (this$maintenanceName == null ? other$maintenanceName != null : !this$maintenanceName.equals(other$maintenanceName))
            return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$employeePesel = this.getEmployeePesel();
        final Object other$employeePesel = other.getEmployeePesel();
        if (this$employeePesel == null ? other$employeePesel != null : !this$employeePesel.equals(other$employeePesel))
            return false;
        final Object this$employeeFirstName = this.getEmployeeFirstName();
        final Object other$employeeFirstName = other.getEmployeeFirstName();
        if (this$employeeFirstName == null ? other$employeeFirstName != null : !this$employeeFirstName.equals(other$employeeFirstName))
            return false;
        final Object this$employeeLatName = this.getEmployeeLatName();
        final Object other$employeeLatName = other.getEmployeeLatName();
        if (this$employeeLatName == null ? other$employeeLatName != null : !this$employeeLatName.equals(other$employeeLatName))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AquaparkMaintenanceDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $attractionMaintenanceId = this.getAttractionMaintenanceId();
        result = result * PRIME + ($attractionMaintenanceId == null ? 43 : $attractionMaintenanceId.hashCode());
        final Object $attractionId = this.getAttractionId();
        result = result * PRIME + ($attractionId == null ? 43 : $attractionId.hashCode());
        final Object $maintenanceName = this.getMaintenanceName();
        result = result * PRIME + ($maintenanceName == null ? 43 : $maintenanceName.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $employeePesel = this.getEmployeePesel();
        result = result * PRIME + ($employeePesel == null ? 43 : $employeePesel.hashCode());
        final Object $employeeFirstName = this.getEmployeeFirstName();
        result = result * PRIME + ($employeeFirstName == null ? 43 : $employeeFirstName.hashCode());
        final Object $employeeLatName = this.getEmployeeLatName();
        result = result * PRIME + ($employeeLatName == null ? 43 : $employeeLatName.hashCode());
        return result;
    }

    public String toString() {
        return "AquaparkMaintenanceDto(attractionMaintenanceId=" + this.getAttractionMaintenanceId() + ", attractionId=" + this.getAttractionId() + ", maintenanceName=" + this.getMaintenanceName() + ", description=" + this.getDescription() + ", date=" + this.getDate() + ", employeePesel=" + this.getEmployeePesel() + ", employeeFirstName=" + this.getEmployeeFirstName() + ", employeeLatName=" + this.getEmployeeLatName() + ")";
    }
}
