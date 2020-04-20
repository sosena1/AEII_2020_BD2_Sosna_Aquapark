package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Role")
public @Data
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private Long roleId;

    @Column(name = "roleName")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<Employee> employees;
}
