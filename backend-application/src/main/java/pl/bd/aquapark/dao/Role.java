package pl.bd.aquapark.dao;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private Long roleId;

    @Column(name = "rolename")
    private String roleName;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Role() {
    }

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

    public Long getRoleId() {
        return this.roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String toString() {
        return "Role(roleId=" + this.getRoleId() + ", roleName=" + this.getRoleName() + ", employees=" + this.getEmployees() + ")";
    }
}
