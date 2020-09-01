package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pricelistitem")
public
class PriceListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricelistitemid")
    private Long priceListItemId;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "conditionalid")
    private Conditions conditions;

    @ManyToOne
    @JoinColumn(name = "pricelistid")
    private PriceList priceList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attractionid")
    private AquaparkAttraction aquaparkAttraction;

    @OneToMany
    @JoinColumn(name = "usageid")
    private List<AquaparkAttractionUsage> aquaparkAttractionUsage;

    public PriceListItem() {
    }

    public Long getPriceListItemId() {
        return this.priceListItemId;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public Conditions getConditions() {
        return this.conditions;
    }

    public AquaparkAttraction getAquaparkAttraction() {
        return this.aquaparkAttraction;
    }

    public void setPriceListItemId(Long priceListItemId) {
        this.priceListItemId = priceListItemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public void setAquaparkAttraction(AquaparkAttraction aquaparkAttraction) {
        this.aquaparkAttraction = aquaparkAttraction;
    }

    public void setAquaparkAttractionUsage(List<AquaparkAttractionUsage> aquaparkAttractionUsage) {
        this.aquaparkAttractionUsage = aquaparkAttractionUsage;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PriceListItem)) return false;
        final PriceListItem other = (PriceListItem) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$priceListItemId = this.getPriceListItemId();
        final Object other$priceListItemId = other.getPriceListItemId();
        if (this$priceListItemId == null ? other$priceListItemId != null : !this$priceListItemId.equals(other$priceListItemId))
            return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$conditions = this.getConditions();
        final Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions))
            return false;
        final Object this$priceList = this.getPriceList();
        final Object other$priceList = other.getPriceList();
        if (this$priceList == null ? other$priceList != null : !this$priceList.equals(other$priceList)) return false;
        final Object this$aquaparkAttraction = this.getAquaparkAttraction();
        final Object other$aquaparkAttraction = other.getAquaparkAttraction();
        if (this$aquaparkAttraction == null ? other$aquaparkAttraction != null : !this$aquaparkAttraction.equals(other$aquaparkAttraction))
            return false;
        final Object this$aquaparkAttractionUsage = this.getAquaparkAttractionUsage();
        final Object other$aquaparkAttractionUsage = other.getAquaparkAttractionUsage();
        if (this$aquaparkAttractionUsage == null ? other$aquaparkAttractionUsage != null : !this$aquaparkAttractionUsage.equals(other$aquaparkAttractionUsage))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PriceListItem;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $priceListItemId = this.getPriceListItemId();
        result = result * PRIME + ($priceListItemId == null ? 43 : $priceListItemId.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $conditions = this.getConditions();
        result = result * PRIME + ($conditions == null ? 43 : $conditions.hashCode());
        final Object $priceList = this.getPriceList();
        result = result * PRIME + ($priceList == null ? 43 : $priceList.hashCode());
        final Object $aquaparkAttraction = this.getAquaparkAttraction();
        result = result * PRIME + ($aquaparkAttraction == null ? 43 : $aquaparkAttraction.hashCode());
        final Object $aquaparkAttractionUsage = this.getAquaparkAttractionUsage();
        result = result * PRIME + ($aquaparkAttractionUsage == null ? 43 : $aquaparkAttractionUsage.hashCode());
        return result;
    }

    public String toString() {
        return "PriceListItem(priceListItemId=" + this.getPriceListItemId() + ", name=" + this.getName() + ", value=" + this.getValue() + ", description=" + this.getDescription() + ", conditions=" + this.getConditions() + ", priceList=" + this.getPriceList() + ", aquaparkAttraction=" + this.getAquaparkAttraction() + ", aquaparkAttractionUsage=" + this.getAquaparkAttractionUsage() + ")";
    }

    @JsonIgnore
    public PriceList getPriceList() {
        return this.priceList;
    }

    @JsonIgnore
    public List<AquaparkAttractionUsage> getAquaparkAttractionUsage() {
        return this.aquaparkAttractionUsage;
    }
}
