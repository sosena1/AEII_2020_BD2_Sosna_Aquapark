package pl.bd.aquapark.dto;

import lombok.Data;
import pl.bd.aquapark.dao.Gender;

public @Data class GenderDto {
    Long genderId;
    String genderName;

    public static GenderDto fromGender(Gender gender) {
        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(gender.getGenderId());
        genderDto.setGenderName(gender.getGenderName());

        return genderDto;
    }
}
