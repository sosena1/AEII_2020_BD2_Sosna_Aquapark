package pl.bd.aquapark.dto;

import pl.bd.aquapark.dao.Gender;

public class GenderDto {
    Long genderId;
    String genderName;

    public GenderDto() {
    }

    public static GenderDto fromGender(Gender gender) {
        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(gender.getGenderId());
        genderDto.setGenderName(gender.getGenderName());

        return genderDto;
    }

    public Long getGenderId() {
        return this.genderId;
    }

    public String getGenderName() {
        return this.genderName;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GenderDto)) return false;
        final GenderDto other = (GenderDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$genderId = this.getGenderId();
        final Object other$genderId = other.getGenderId();
        if (this$genderId == null ? other$genderId != null : !this$genderId.equals(other$genderId)) return false;
        final Object this$genderName = this.getGenderName();
        final Object other$genderName = other.getGenderName();
        if (this$genderName == null ? other$genderName != null : !this$genderName.equals(other$genderName))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GenderDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $genderId = this.getGenderId();
        result = result * PRIME + ($genderId == null ? 43 : $genderId.hashCode());
        final Object $genderName = this.getGenderName();
        result = result * PRIME + ($genderName == null ? 43 : $genderName.hashCode());
        return result;
    }

    public String toString() {
        return "GenderDto(genderId=" + this.getGenderId() + ", genderName=" + this.getGenderName() + ")";
    }
}
