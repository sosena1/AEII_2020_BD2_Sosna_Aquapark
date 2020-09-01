package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conditions")
public
class Conditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conditionid")
    private Long conditionId;

    @Column(name = "weekendonly")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean weekendOnly;

    @Column(name = "childonly")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean childOnly;

    @Column(name = "senioronly")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean seniorOnly;

    @OneToMany
    @JoinColumn(name = "conditionalid")
    private List<PriceListItem> priceListItemList;

    public Conditions() {
    }

    public Long getConditionId() {
        return this.conditionId;
    }

    public Boolean getWeekendOnly() {
        return this.weekendOnly;
    }

    public Boolean getChildOnly() {
        return this.childOnly;
    }

    public Boolean getSeniorOnly() {
        return this.seniorOnly;
    }

    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }

    public void setWeekendOnly(Boolean weekendOnly) {
        this.weekendOnly = weekendOnly;
    }

    public void setChildOnly(Boolean childOnly) {
        this.childOnly = childOnly;
    }

    public void setSeniorOnly(Boolean seniorOnly) {
        this.seniorOnly = seniorOnly;
    }

    public void setPriceListItemList(List<PriceListItem> priceListItemList) {
        this.priceListItemList = priceListItemList;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Conditions)) return false;
        final Conditions other = (Conditions) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$conditionId = this.getConditionId();
        final Object other$conditionId = other.getConditionId();
        if (this$conditionId == null ? other$conditionId != null : !this$conditionId.equals(other$conditionId))
            return false;
        final Object this$weekendOnly = this.getWeekendOnly();
        final Object other$weekendOnly = other.getWeekendOnly();
        if (this$weekendOnly == null ? other$weekendOnly != null : !this$weekendOnly.equals(other$weekendOnly))
            return false;
        final Object this$childOnly = this.getChildOnly();
        final Object other$childOnly = other.getChildOnly();
        if (this$childOnly == null ? other$childOnly != null : !this$childOnly.equals(other$childOnly)) return false;
        final Object this$seniorOnly = this.getSeniorOnly();
        final Object other$seniorOnly = other.getSeniorOnly();
        if (this$seniorOnly == null ? other$seniorOnly != null : !this$seniorOnly.equals(other$seniorOnly))
            return false;
        final Object this$priceListItemList = this.getPriceListItemList();
        final Object other$priceListItemList = other.getPriceListItemList();
        if (this$priceListItemList == null ? other$priceListItemList != null : !this$priceListItemList.equals(other$priceListItemList))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Conditions;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $conditionId = this.getConditionId();
        result = result * PRIME + ($conditionId == null ? 43 : $conditionId.hashCode());
        final Object $weekendOnly = this.getWeekendOnly();
        result = result * PRIME + ($weekendOnly == null ? 43 : $weekendOnly.hashCode());
        final Object $childOnly = this.getChildOnly();
        result = result * PRIME + ($childOnly == null ? 43 : $childOnly.hashCode());
        final Object $seniorOnly = this.getSeniorOnly();
        result = result * PRIME + ($seniorOnly == null ? 43 : $seniorOnly.hashCode());
        final Object $priceListItemList = this.getPriceListItemList();
        result = result * PRIME + ($priceListItemList == null ? 43 : $priceListItemList.hashCode());
        return result;
    }

    public String toString() {
        return "Conditions(conditionId=" + this.getConditionId() + ", weekendOnly=" + this.getWeekendOnly() + ", childOnly=" + this.getChildOnly() + ", seniorOnly=" + this.getSeniorOnly() + ", priceListItemList=" + this.getPriceListItemList() + ")";
    }

    @JsonIgnore
    public List<PriceListItem> getPriceListItemList() {
        return this.priceListItemList;
    }
}
