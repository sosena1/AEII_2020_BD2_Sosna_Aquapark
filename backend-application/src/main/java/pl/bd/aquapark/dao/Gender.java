package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gender")
public @Data
class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genderid")
    private Long genderId;

    @Column(name = "gendername")
    private String genderName;

    @OneToMany
    @JoinColumn(name = "genderId")
    private Set<User> users;
}
