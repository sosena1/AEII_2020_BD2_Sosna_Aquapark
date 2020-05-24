package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employee")
public @Data
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
    private Set<Role> roles;

    @OneToMany
    @JoinColumn(name = "employeeid")
    private List<AquaparkAttractionMaintenance> aquaparkAttractionMaintenances;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                '}';
    }
}
