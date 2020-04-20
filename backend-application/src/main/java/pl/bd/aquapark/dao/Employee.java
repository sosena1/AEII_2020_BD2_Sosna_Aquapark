package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Employee")
public @Data
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private Long employeeId;

    @OneToOne(mappedBy = "employee")
    private User user;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<PriceList> priceLists;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Role_has_Employee",
            joinColumns = {@JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")}
    )
    private Set<Role> roles;

    @OneToMany
    @JoinColumn(name = "employeeId")
    private List<AquaparkAttractionMaintenance> aquaparkAttractionMaintenances;

}
