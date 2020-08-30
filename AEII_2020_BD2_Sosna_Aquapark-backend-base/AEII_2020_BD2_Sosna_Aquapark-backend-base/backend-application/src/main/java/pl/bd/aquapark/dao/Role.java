package pl.bd.aquapark.dao;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public @Data
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private Long roleId;

    @Column(name = "rolename")
    private String roleName;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (!roleId.equals(role.roleId)) return false;
        return roleName.equals(role.roleName);
    }

    @Override
    public int hashCode() {
        int result = roleId.hashCode();
        result = 31 * result + roleName.hashCode();
        return result;
    }
}
