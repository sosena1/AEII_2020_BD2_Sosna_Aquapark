package pl.bd.aquapark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public @Data @AllArgsConstructor class SetPriceListDto {
    private final List<SetPriceListItem> items;
    private Date validityDate;


    public static @Data @AllArgsConstructor class SetPriceListItem {
        private final String name;
        private final BigDecimal value;
        private final String description;
        private final boolean childOnly;
        private final boolean weekendOnly;
        private final boolean seniorOnly;
        private final Long attractionId;

    }
}
