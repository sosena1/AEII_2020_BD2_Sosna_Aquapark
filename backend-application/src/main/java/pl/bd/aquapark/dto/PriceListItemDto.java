package pl.bd.aquapark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.bd.aquapark.dao.AquaparkAttraction;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;
import pl.bd.aquapark.dao.Conditions;
import pl.bd.aquapark.dao.PriceListItem;
import pl.bd.aquapark.service.DateService;

import java.math.BigDecimal;
import java.sql.Date;

public @Data @AllArgsConstructor
class PriceListItemDto {
    private Long priceListItemId;
    private String name;
    private String description;
    private BigDecimal value;
    private boolean weekendOnly;
    private boolean childOnly;
    private boolean seniorOnly;
    private String attractionName;


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
}
