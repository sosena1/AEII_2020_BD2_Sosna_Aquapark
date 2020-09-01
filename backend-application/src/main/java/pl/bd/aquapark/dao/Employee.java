package pl.bd.aquapark.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid")
    private Long employeeId;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @OneToMany
    @JoinColumn(name = "employeeid")
    private List<PriceList> priceLists;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_has_employee",
            joinColumns = {@JoinColumn(name = "employeeid")},
            inverseJoinColumns = {@JoinColumn(name = "roleid")}
    )
    private List<Role> roles;

    @OneToMany
    @JoinColumn(name = "employeeid")
    private List<AquaparkAttractionMaintenance> aquaparkAttractionMaintenances;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                '}';
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public User getUser() {
        return this.user;
    }

    public List<PriceList> getPriceLists() {
        return this.priceLists;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public List<AquaparkAttractionMaintenance> getAquaparkAttractionMaintenances() {
        return this.aquaparkAttractionMaintenances;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPriceLists(List<PriceList> priceLists) {
        this.priceLists = priceLists;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setAquaparkAttractionMaintenances(List<AquaparkAttractionMaintenance> aquaparkAttractionMaintenances) {
        this.aquaparkAttractionMaintenances = aquaparkAttractionMaintenances;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Employee)) return false;
        final Employee other = (Employee) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$employeeId = this.getEmployeeId();
        final Object other$employeeId = other.getEmployeeId();
        if (this$employeeId == null ? other$employeeId != null : !this$employeeId.equals(other$employeeId))
            return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$priceLists = this.getPriceLists();
        final Object other$priceLists = other.getPriceLists();
        if (this$priceLists == null ? other$priceLists != null : !this$priceLists.equals(other$priceLists))
            return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
        final Object this$aquaparkAttractionMaintenances = this.getAquaparkAttractionMaintenances();
        final Object other$aquaparkAttractionMaintenances = other.getAquaparkAttractionMaintenances();
        if (this$aquaparkAttractionMaintenances == null ? other$aquaparkAttractionMaintenances != null : !this$aquaparkAttractionMaintenances.equals(other$aquaparkAttractionMaintenances))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Employee;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $employeeId = this.getEmployeeId();
        result = result * PRIME + ($employeeId == null ? 43 : $employeeId.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $priceLists = this.getPriceLists();
        result = result * PRIME + ($priceLists == null ? 43 : $priceLists.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        final Object $aquaparkAttractionMaintenances = this.getAquaparkAttractionMaintenances();
        result = result * PRIME + ($aquaparkAttractionMaintenances == null ? 43 : $aquaparkAttractionMaintenances.hashCode());
        return result;
    }
}
