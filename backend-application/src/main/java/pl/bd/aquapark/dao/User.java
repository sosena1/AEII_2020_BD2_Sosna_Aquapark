package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@JsonIgnoreProperties
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private Long userId;

    @Size(max = 45, message = "first name can be up to 45 characters long")
    @Column(name = "firstname", nullable = true)
    private String firstName;

    @Size(max = 45, message = "last name can be up to 45 characters long")
    @Column(name = "lastname", nullable = true)
    private String lastName;

    @Size(max = 45, message = "address can be up to 45 characters long")
    @Column(name = "address", nullable = true)
    private String address;

    @Size(max = 45, message = "contact number can be up to 45 characters long")
    @Column(name = "contactnumber", nullable = true)
    private String contactNumber;

    @Size(max = 45, message = "other information can be up to 45 characters long")
    @Column(name = "otherinformation", nullable = true)
    private String otherInformation;

    @Size(max = 45, message = "username can be up to 45 characters long")
    @Column(name = "username", nullable = true)
    private String userName;

    @Size(max = 45, message = "password can be up to 45 characters long")
    @Column(name = "password", nullable = true)
    private String password;

    @Size(max = 45, message = "pesel can be up to 45 characters long")
    @Column(name = "pesel", nullable = true)
    private String pesel;

    @Column(name = "birthdate", nullable = true)
    private Date birthDate;

    @OneToOne(mappedBy = "user")
    private Client client;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "genderid")
    private Gender gender;

    public User() {
    }

    public boolean getIsClient() {
        return client != null;
    }

    public boolean getIsEmployee() {
        return employee != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (contactNumber != null ? !contactNumber.equals(user.contactNumber) : user.contactNumber != null)
            return false;
        if (otherInformation != null ? !otherInformation.equals(user.otherInformation) : user.otherInformation != null)
            return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (pesel != null ? !pesel.equals(user.pesel) : user.pesel != null) return false;
        if (birthDate != null ? !birthDate.equals(user.birthDate) : user.birthDate != null) return false;
        return gender != null ? gender.equals(user.gender) : user.gender == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        result = 31 * result + (otherInformation != null ? otherInformation.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                '}';
    }

    public Long getUserId() {
        return this.userId;
    }

    public @Size(max = 45, message = "first name can be up to 45 characters long") String getFirstName() {
        return this.firstName;
    }

    public @Size(max = 45, message = "last name can be up to 45 characters long") String getLastName() {
        return this.lastName;
    }

    public @Size(max = 45, message = "address can be up to 45 characters long") String getAddress() {
        return this.address;
    }

    public @Size(max = 45, message = "contact number can be up to 45 characters long") String getContactNumber() {
        return this.contactNumber;
    }

    public @Size(max = 45, message = "other information can be up to 45 characters long") String getOtherInformation() {
        return this.otherInformation;
    }

    public @Size(max = 45, message = "username can be up to 45 characters long") String getUserName() {
        return this.userName;
    }

    public @Size(max = 45, message = "pesel can be up to 45 characters long") String getPesel() {
        return this.pesel;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFirstName(@Size(max = 45, message = "first name can be up to 45 characters long") String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@Size(max = 45, message = "last name can be up to 45 characters long") String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(@Size(max = 45, message = "address can be up to 45 characters long") String address) {
        this.address = address;
    }

    public void setContactNumber(@Size(max = 45, message = "contact number can be up to 45 characters long") String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setOtherInformation(@Size(max = 45, message = "other information can be up to 45 characters long") String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public void setUserName(@Size(max = 45, message = "username can be up to 45 characters long") String userName) {
        this.userName = userName;
    }

    public void setPassword(@Size(max = 45, message = "password can be up to 45 characters long") String password) {
        this.password = password;
    }

    public void setPesel(@Size(max = 45, message = "pesel can be up to 45 characters long") String pesel) {
        this.pesel = pesel;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @JsonIgnore
    public @Size(max = 45, message = "password can be up to 45 characters long") String getPassword() {
        return this.password;
    }

    @JsonIgnore
    public Client getClient() {
        return this.client;
    }

    @JsonIgnore
    public Employee getEmployee() {
        return this.employee;
    }
}
