package pl.bd.aquapark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

public @Data @AllArgsConstructor
class AnonymousVisitDto {
    private final String firstName;
    private final String lastName;
    private final Long sexId;
    private final Date birthDate;
    private final Long clientIdentificator;

}
