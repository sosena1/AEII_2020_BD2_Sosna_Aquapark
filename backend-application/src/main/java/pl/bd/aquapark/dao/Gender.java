package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Gender")
public @Data
class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genderId")
    private Long roleId;

    @Column(name = "genderName")
    private String genderName;

    @OneToMany
    @JoinColumn(name = "genderId")
    private Set<User> users;
}
