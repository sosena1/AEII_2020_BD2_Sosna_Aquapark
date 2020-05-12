package pl.bd.aquapark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

public @Data @AllArgsConstructor class UserCreateDto {

    private String name;
    private String surname;
    private String pesel;
    private Long genderId;
    private String address;
    private String contactNumber;
    private String userName;
    private String password;
    private Date birthDate;
    private String otherInformation;
}
