package pl.bd.aquapark.dto;

import pl.bd.aquapark.dao.Conditions;
import pl.bd.aquapark.dao.PriceListItem;

import java.math.BigDecimal;

public
class PriceListItemDto {
    private Long priceListItemId;
    private String name;
    private String description;
    private BigDecimal value;
    private boolean weekendOnly;
    private boolean childOnly;
    private boolean seniorOnly;
    private String attractionName;

    public PriceListItemDto(Long priceListItemId, String name, String description, BigDecimal value, boolean weekendOnly, boolean childOnly, boolean seniorOnly, String attractionName) {
        this.priceListItemId = priceListItemId;
        this.name = name;
        this.description = description;
        this.value = value;
        this.weekendOnly = weekendOnly;
        this.childOnly = childOnly;
        this.seniorOnly = seniorOnly;
        this.attractionName = attractionName;
    }


    public static PriceListItemDto fromPriceListItem(PriceListItem pli) {
        Conditions con = pli.getConditions();
        return new PriceListItemDto(
                pli.getPriceListItemId(),
                pli.getName(),
                pli.getDescription(),
                pli.getValue(),
                con.getWeekendOnly(),
                con.getChildOnly(),
                con.getSeniorOnly(),
                pli.getAquaparkAttraction().getName()
        );
    }

    public Long getPriceListItemId() {
        return this.priceListItemId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public boolean isWeekendOnly() {
        return this.weekendOnly;
    }

    public boolean isChildOnly() {
        return this.childOnly;
    }

    public boolean isSeniorOnly() {
        return this.seniorOnly;
    }

    public String getAttractionName() {
        return this.attractionName;
    }

    public void setPriceListItemId(Long priceListItemId) {
        this.priceListItemId = priceListItemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setWeekendOnly(boolean weekendOnly) {
        this.weekendOnly = weekendOnly;
    }

    public void setChildOnly(boolean childOnly) {
        this.childOnly = childOnly;
    }

    public void setSeniorOnly(boolean seniorOnly) {
        this.seniorOnly = seniorOnly;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PriceListItemDto)) return false;
        final PriceListItemDto other = (PriceListItemDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$priceListItemId = this.getPriceListItemId();
        final Object other$priceListItemId = other.getPriceListItemId();
        if (this$priceListItemId == null ? other$priceListItemId != null : !this$priceListItemId.equals(other$priceListItemId))
            return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
        if (this.isWeekendOnly() != other.isWeekendOnly()) return false;
        if (this.isChildOnly() != other.isChildOnly()) return false;
        if (this.isSeniorOnly() != other.isSeniorOnly()) return false;
        final Object this$attractionName = this.getAttractionName();
        final Object other$attractionName = other.getAttractionName();
        if (this$attractionName == null ? other$attractionName != null : !this$attractionName.equals(other$attractionName))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PriceListItemDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $priceListItemId = this.getPriceListItemId();
        result = result * PRIME + ($priceListItemId == null ? 43 : $priceListItemId.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        result = result * PRIME + (this.isWeekendOnly() ? 79 : 97);
        result = result * PRIME + (this.isChildOnly() ? 79 : 97);
        result = result * PRIME + (this.isSeniorOnly() ? 79 : 97);
        final Object $attractionName = this.getAttractionName();
        result = result * PRIME + ($attractionName == null ? 43 : $attractionName.hashCode());
        return result;
    }

    public String toString() {
        return "PriceListItemDto(priceListItemId=" + this.getPriceListItemId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", value=" + this.getValue() + ", weekendOnly=" + this.isWeekendOnly() + ", childOnly=" + this.isChildOnly() + ", seniorOnly=" + this.isSeniorOnly() + ", attractionName=" + this.getAttractionName() + ")";
    }
}
