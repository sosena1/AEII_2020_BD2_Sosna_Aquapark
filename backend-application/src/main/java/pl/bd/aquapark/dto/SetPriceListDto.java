package pl.bd.aquapark.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class SetPriceListDto {
    private final List<SetPriceListItem> items;
    private Date validityDate;

    public SetPriceListDto(List<SetPriceListItem> items, Date validityDate) {
        this.items = items;
        this.validityDate = validityDate;
    }

    public List<SetPriceListItem> getItems() {
        return this.items;
    }

    public Date getValidityDate() {
        return this.validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SetPriceListDto)) return false;
        final SetPriceListDto other = (SetPriceListDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$items = this.getItems();
        final Object other$items = other.getItems();
        if (this$items == null ? other$items != null : !this$items.equals(other$items)) return false;
        final Object this$validityDate = this.getValidityDate();
        final Object other$validityDate = other.getValidityDate();
        if (this$validityDate == null ? other$validityDate != null : !this$validityDate.equals(other$validityDate))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SetPriceListDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $items = this.getItems();
        result = result * PRIME + ($items == null ? 43 : $items.hashCode());
        final Object $validityDate = this.getValidityDate();
        result = result * PRIME + ($validityDate == null ? 43 : $validityDate.hashCode());
        return result;
    }

    public String toString() {
        return "SetPriceListDto(items=" + this.getItems() + ", validityDate=" + this.getValidityDate() + ")";
    }


    public static class SetPriceListItem {
        private final String name;
        private final BigDecimal value;
        private final String description;
        private final boolean childOnly;
        private final boolean weekendOnly;
        private final boolean seniorOnly;
        private final Long attractionId;

        public SetPriceListItem(String name, BigDecimal value, String description, boolean childOnly, boolean weekendOnly, boolean seniorOnly, Long attractionId) {
            this.name = name;
            this.value = value;
            this.description = description;
            this.childOnly = childOnly;
            this.weekendOnly = weekendOnly;
            this.seniorOnly = seniorOnly;
            this.attractionId = attractionId;
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

        public boolean isChildOnly() {
            return this.childOnly;
        }

        public boolean isWeekendOnly() {
            return this.weekendOnly;
        }

        public boolean isSeniorOnly() {
            return this.seniorOnly;
        }

        public Long getAttractionId() {
            return this.attractionId;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof SetPriceListItem)) return false;
            final SetPriceListItem other = (SetPriceListItem) o;
            if (!other.canEqual((Object) this)) return false;
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
            if (this.isChildOnly() != other.isChildOnly()) return false;
            if (this.isWeekendOnly() != other.isWeekendOnly()) return false;
            if (this.isSeniorOnly() != other.isSeniorOnly()) return false;
            final Object this$attractionId = this.getAttractionId();
            final Object other$attractionId = other.getAttractionId();
            if (this$attractionId == null ? other$attractionId != null : !this$attractionId.equals(other$attractionId))
                return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof SetPriceListItem;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $name = this.getName();
            result = result * PRIME + ($name == null ? 43 : $name.hashCode());
            final Object $value = this.getValue();
            result = result * PRIME + ($value == null ? 43 : $value.hashCode());
            final Object $description = this.getDescription();
            result = result * PRIME + ($description == null ? 43 : $description.hashCode());
            result = result * PRIME + (this.isChildOnly() ? 79 : 97);
            result = result * PRIME + (this.isWeekendOnly() ? 79 : 97);
            result = result * PRIME + (this.isSeniorOnly() ? 79 : 97);
            final Object $attractionId = this.getAttractionId();
            result = result * PRIME + ($attractionId == null ? 43 : $attractionId.hashCode());
            return result;
        }

        public String toString() {
            return "SetPriceListDto.SetPriceListItem(name=" + this.getName() + ", value=" + this.getValue() + ", description=" + this.getDescription() + ", childOnly=" + this.isChildOnly() + ", weekendOnly=" + this.isWeekendOnly() + ", seniorOnly=" + this.isSeniorOnly() + ", attractionId=" + this.getAttractionId() + ")";
        }
    }
}
