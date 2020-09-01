package pl.bd.aquapark.dto;

import java.sql.Date;

public class UserCreateDto {

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

    public UserCreateDto(String name, String surname, String pesel, Long genderId, String address, String contactNumber, String userName, String password, Date birthDate, String otherInformation) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.genderId = genderId;
        this.address = address;
        this.contactNumber = contactNumber;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.otherInformation = otherInformation;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPesel() {
        return this.pesel;
    }

    public Long getGenderId() {
        return this.genderId;
    }

    public String getAddress() {
        return this.address;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public String getOtherInformation() {
        return this.otherInformation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserCreateDto)) return false;
        final UserCreateDto other = (UserCreateDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        final Object this$pesel = this.getPesel();
        final Object other$pesel = other.getPesel();
        if (this$pesel == null ? other$pesel != null : !this$pesel.equals(other$pesel)) return false;
        final Object this$genderId = this.getGenderId();
        final Object other$genderId = other.getGenderId();
        if (this$genderId == null ? other$genderId != null : !this$genderId.equals(other$genderId)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$contactNumber = this.getContactNumber();
        final Object other$contactNumber = other.getContactNumber();
        if (this$contactNumber == null ? other$contactNumber != null : !this$contactNumber.equals(other$contactNumber))
            return false;
        final Object this$userName = this.getUserName();
        final Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$birthDate = this.getBirthDate();
        final Object other$birthDate = other.getBirthDate();
        if (this$birthDate == null ? other$birthDate != null : !this$birthDate.equals(other$birthDate)) return false;
        final Object this$otherInformation = this.getOtherInformation();
        final Object other$otherInformation = other.getOtherInformation();
        if (this$otherInformation == null ? other$otherInformation != null : !this$otherInformation.equals(other$otherInformation))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserCreateDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $pesel = this.getPesel();
        result = result * PRIME + ($pesel == null ? 43 : $pesel.hashCode());
        final Object $genderId = this.getGenderId();
        result = result * PRIME + ($genderId == null ? 43 : $genderId.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $contactNumber = this.getContactNumber();
        result = result * PRIME + ($contactNumber == null ? 43 : $contactNumber.hashCode());
        final Object $userName = this.getUserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $birthDate = this.getBirthDate();
        result = result * PRIME + ($birthDate == null ? 43 : $birthDate.hashCode());
        final Object $otherInformation = this.getOtherInformation();
        result = result * PRIME + ($otherInformation == null ? 43 : $otherInformation.hashCode());
        return result;
    }

    public String toString() {
        return "UserCreateDto(name=" + this.getName() + ", surname=" + this.getSurname() + ", pesel=" + this.getPesel() + ", genderId=" + this.getGenderId() + ", address=" + this.getAddress() + ", contactNumber=" + this.getContactNumber() + ", userName=" + this.getUserName() + ", password=" + this.getPassword() + ", birthDate=" + this.getBirthDate() + ", otherInformation=" + this.getOtherInformation() + ")";
    }
}
