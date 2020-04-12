package pl.bd.aquapark.endpoint.user.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = {"visits"})
public @Data
class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    protected Long userId;

    @NotBlank
    @Size(max = 20, message = "first name can be up to 20 characters long")
    @Column(name = "first_name", nullable = false)
    protected String firstName;

    @NotBlank
    @Size(max = 20, message = "last name can be up to 20 characters long")
    @Column(name = "last_name", nullable = false)
    protected String lastName;

    @NotBlank
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "sex_id", nullable = false)
    protected Gender gender;

    @NotBlank
    @Size(max = 20, message = "username can be up to 20 characters long")
    @Column(name = "user_name", nullable = false)
    protected String userName;


    @NotBlank
    @Size(max = 20, message = "password can be up to 20 characters long")
    @Column(name = "password", nullable = false)
    protected String password;

}
