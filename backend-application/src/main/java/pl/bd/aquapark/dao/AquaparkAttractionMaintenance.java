package pl.bd.aquapark.dao;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "aquaparkattractionmaintenance")
public class AquaparkAttractionMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attractionmaintenanceid")
    private Long attractionMaintenanceId;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeid")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private AquaparkAttraction aquaparkAttraction;

    public AquaparkAttractionMaintenance() {
    }

    public Long getAttractionMaintenanceId() {
        return this.attractionMaintenanceId;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDate() {
        return this.date;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public AquaparkAttraction getAquaparkAttraction() {
        return this.aquaparkAttraction;
    }

    public void setAttractionMaintenanceId(Long attractionMaintenanceId) {
        this.attractionMaintenanceId = attractionMaintenanceId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setAquaparkAttraction(AquaparkAttraction aquaparkAttraction) {
        this.aquaparkAttraction = aquaparkAttraction;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AquaparkAttractionMaintenance)) return false;
        final AquaparkAttractionMaintenance other = (AquaparkAttractionMaintenance) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$attractionMaintenanceId = this.getAttractionMaintenanceId();
        final Object other$attractionMaintenanceId = other.getAttractionMaintenanceId();
        if (this$attractionMaintenanceId == null ? other$attractionMaintenanceId != null : !this$attractionMaintenanceId.equals(other$attractionMaintenanceId))
            return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$employee = this.getEmployee();
        final Object other$employee = other.getEmployee();
        if (this$employee == null ? other$employee != null : !this$employee.equals(other$employee)) return false;
        final Object this$aquaparkAttraction = this.getAquaparkAttraction();
        final Object other$aquaparkAttraction = other.getAquaparkAttraction();
        if (this$aquaparkAttraction == null ? other$aquaparkAttraction != null : !this$aquaparkAttraction.equals(other$aquaparkAttraction))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AquaparkAttractionMaintenance;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $attractionMaintenanceId = this.getAttractionMaintenanceId();
        result = result * PRIME + ($attractionMaintenanceId == null ? 43 : $attractionMaintenanceId.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $employee = this.getEmployee();
        result = result * PRIME + ($employee == null ? 43 : $employee.hashCode());
        final Object $aquaparkAttraction = this.getAquaparkAttraction();
        result = result * PRIME + ($aquaparkAttraction == null ? 43 : $aquaparkAttraction.hashCode());
        return result;
    }

    public String toString() {
        return "AquaparkAttractionMaintenance(attractionMaintenanceId=" + this.getAttractionMaintenanceId() + ", description=" + this.getDescription() + ", date=" + this.getDate() + ", employee=" + this.getEmployee() + ", aquaparkAttraction=" + this.getAquaparkAttraction() + ")";
    }
}
