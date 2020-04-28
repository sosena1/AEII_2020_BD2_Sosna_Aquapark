package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AquaparkAttraction")
public @Data
class AquaparkAttraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attractionId")
    private Long attractionId;

    @Column(name = "maxUsers")
    private Long maxUsers;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "attractionId")
    private List<AquaparkAttractionGate> aquaparkAttractionGates;

    @OneToMany
    @JoinColumn(name = "attractionId")
    private List<AquaparkAttractionUsage> aquaparkAttractionUsages;

    @OneToMany
    @JoinColumn(name = "attractionId")
    private List<AquaparkAttractionMaintenance> aquaparkAttractionMaintenances;
}
