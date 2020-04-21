package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties
@Entity
@Table(name = "User")
 @Data public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    protected Long userId;

    @Size(max = 45, message = "first name can be up to 45 characters long")
    @Column(name = "firstName", nullable = true)
    protected String firstName;

    @Size(max = 45, message = "last name can be up to 45 characters long")
    @Column(name = "lastName", nullable = true)
    protected String lastName;

    @Size(max = 45, message = "address can be up to 45 characters long")
    @Column(name = "address", nullable = true)
    protected String address;

    @Size(max = 45, message = "contact number can be up to 45 characters long")
    @Column(name = "contactNumber", nullable = true)
    protected String contactNumber;

    @Size(max = 45, message = "other information can be up to 45 characters long")
    @Column(name = "otherInformation", nullable = true)
    protected String otherInformation;

    @Size(max = 45, message = "username can be up to 45 characters long")
    @Column(name = "userName", nullable = true)
    protected String userName;

    @Size(max = 45, message = "password can be up to 45 characters long")
    @Column(name = "password", nullable = true)
    protected String password;

    @Size(max = 45, message = "pesel can be up to 45 characters long")
    @Column(name = "pesel", nullable = true)
    protected String pesel;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthDate", nullable = true)
    protected Date birthDate;

    @OneToOne(optional = true)
    @JoinColumn(name = "userId", referencedColumnName = "clientId")
    protected Client client;


   @OneToOne(optional = true)
   @JoinColumn(name = "userId", referencedColumnName = "employeeId")
   protected Employee employee;

}
