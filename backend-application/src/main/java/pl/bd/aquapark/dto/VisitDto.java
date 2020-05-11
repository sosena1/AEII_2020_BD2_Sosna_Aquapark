package pl.bd.aquapark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public @Data @AllArgsConstructor class VisitDto {
    private Long userId;
    private Long identificatorId;
}
