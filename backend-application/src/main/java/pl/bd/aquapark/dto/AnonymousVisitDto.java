package pl.bd.aquapark.dto;

import java.sql.Date;

public
class AnonymousVisitDto {
    private final String firstName;
    private final String lastName;
    private final Long sexId;
    private final Date birthDate;
    private final Long identificatorId;

    public AnonymousVisitDto(String firstName, String lastName, Long sexId, Date birthDate, Long identificatorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sexId = sexId;
        this.birthDate = birthDate;
        this.identificatorId = identificatorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Long getSexId() {
        return this.sexId;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public Long getIdentificatorId() {
        return this.identificatorId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AnonymousVisitDto)) return false;
        final AnonymousVisitDto other = (AnonymousVisitDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$sexId = this.getSexId();
        final Object other$sexId = other.getSexId();
        if (this$sexId == null ? other$sexId != null : !this$sexId.equals(other$sexId)) return false;
        final Object this$birthDate = this.getBirthDate();
        final Object other$birthDate = other.getBirthDate();
        if (this$birthDate == null ? other$birthDate != null : !this$birthDate.equals(other$birthDate)) return false;
        final Object this$identificatorId = this.getIdentificatorId();
        final Object other$identificatorId = other.getIdentificatorId();
        if (this$identificatorId == null ? other$identificatorId != null : !this$identificatorId.equals(other$identificatorId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AnonymousVisitDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $sexId = this.getSexId();
        result = result * PRIME + ($sexId == null ? 43 : $sexId.hashCode());
        final Object $birthDate = this.getBirthDate();
        result = result * PRIME + ($birthDate == null ? 43 : $birthDate.hashCode());
        final Object $identificatorId = this.getIdentificatorId();
        result = result * PRIME + ($identificatorId == null ? 43 : $identificatorId.hashCode());
        return result;
    }

    public String toString() {
        return "AnonymousVisitDto(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", sexId=" + this.getSexId() + ", birthDate=" + this.getBirthDate() + ", identificatorId=" + this.getIdentificatorId() + ")";
    }
}
