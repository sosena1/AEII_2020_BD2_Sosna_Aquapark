package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aquaparkattraction")
public
class AquaparkAttraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attractionid")
    private Long attractionId;

    @Column(name = "maxusers")
    private Long maxUsers;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private List<AquaparkAttractionGate> aquaparkAttractionGates;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private List<AquaparkAttractionUsage> aquaparkAttractionUsages;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private List<PriceListItem> priceListItems;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private List<AquaparkAttractionMaintenance> aquaparkAttractionMaintenances;

    public AquaparkAttraction() {
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

    public void setAttractionId(Long attractionId) {
        this.attractionId = attractionId;
    }

    public void setMaxUsers(Long maxUsers) {
        this.maxUsers = maxUsers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAquaparkAttractionGates(List<AquaparkAttractionGate> aquaparkAttractionGates) {
        this.aquaparkAttractionGates = aquaparkAttractionGates;
    }

    public void setAquaparkAttractionUsages(List<AquaparkAttractionUsage> aquaparkAttractionUsages) {
        this.aquaparkAttractionUsages = aquaparkAttractionUsages;
    }

    public void setPriceListItems(List<PriceListItem> priceListItems) {
        this.priceListItems = priceListItems;
    }

    public void setAquaparkAttractionMaintenances(List<AquaparkAttractionMaintenance> aquaparkAttractionMaintenances) {
        this.aquaparkAttractionMaintenances = aquaparkAttractionMaintenances;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AquaparkAttraction)) return false;
        final AquaparkAttraction other = (AquaparkAttraction) o;
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
        final Object this$aquaparkAttractionGates = this.getAquaparkAttractionGates();
        final Object other$aquaparkAttractionGates = other.getAquaparkAttractionGates();
        if (this$aquaparkAttractionGates == null ? other$aquaparkAttractionGates != null : !this$aquaparkAttractionGates.equals(other$aquaparkAttractionGates))
            return false;
        final Object this$aquaparkAttractionUsages = this.getAquaparkAttractionUsages();
        final Object other$aquaparkAttractionUsages = other.getAquaparkAttractionUsages();
        if (this$aquaparkAttractionUsages == null ? other$aquaparkAttractionUsages != null : !this$aquaparkAttractionUsages.equals(other$aquaparkAttractionUsages))
            return false;
        final Object this$priceListItems = this.getPriceListItems();
        final Object other$priceListItems = other.getPriceListItems();
        if (this$priceListItems == null ? other$priceListItems != null : !this$priceListItems.equals(other$priceListItems))
            return false;
        final Object this$aquaparkAttractionMaintenances = this.getAquaparkAttractionMaintenances();
        final Object other$aquaparkAttractionMaintenances = other.getAquaparkAttractionMaintenances();
        if (this$aquaparkAttractionMaintenances == null ? other$aquaparkAttractionMaintenances != null : !this$aquaparkAttractionMaintenances.equals(other$aquaparkAttractionMaintenances))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AquaparkAttraction;
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
        final Object $aquaparkAttractionGates = this.getAquaparkAttractionGates();
        result = result * PRIME + ($aquaparkAttractionGates == null ? 43 : $aquaparkAttractionGates.hashCode());
        final Object $aquaparkAttractionUsages = this.getAquaparkAttractionUsages();
        result = result * PRIME + ($aquaparkAttractionUsages == null ? 43 : $aquaparkAttractionUsages.hashCode());
        final Object $priceListItems = this.getPriceListItems();
        result = result * PRIME + ($priceListItems == null ? 43 : $priceListItems.hashCode());
        final Object $aquaparkAttractionMaintenances = this.getAquaparkAttractionMaintenances();
        result = result * PRIME + ($aquaparkAttractionMaintenances == null ? 43 : $aquaparkAttractionMaintenances.hashCode());
        return result;
    }

    public String toString() {
        return "AquaparkAttraction(attractionId=" + this.getAttractionId() + ", maxUsers=" + this.getMaxUsers() + ", name=" + this.getName() + ", aquaparkAttractionGates=" + this.getAquaparkAttractionGates() + ", aquaparkAttractionUsages=" + this.getAquaparkAttractionUsages() + ", priceListItems=" + this.getPriceListItems() + ", aquaparkAttractionMaintenances=" + this.getAquaparkAttractionMaintenances() + ")";
    }

    @JsonIgnore
    public List<AquaparkAttractionGate> getAquaparkAttractionGates() {
        return this.aquaparkAttractionGates;
    }

    @JsonIgnore
    public List<AquaparkAttractionUsage> getAquaparkAttractionUsages() {
        return this.aquaparkAttractionUsages;
    }

    @JsonIgnore
    public List<PriceListItem> getPriceListItems() {
        return this.priceListItems;
    }

    @JsonIgnore
    public List<AquaparkAttractionMaintenance> getAquaparkAttractionMaintenances() {
        return this.aquaparkAttractionMaintenances;
    }
}
