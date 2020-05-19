package pl.bd.aquapark.dao;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aquaparkattraction")
public @Data
class AquaparkAttraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attractionid")
    private Long attractionId;

    @Column(name = "maxusers")
    private Long maxUsers;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private List<AquaparkAttractionGate> aquaparkAttractionGates;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private List<AquaparkAttractionUsage> aquaparkAttractionUsages;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private List<PriceListItem> priceListItems;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private List<AquaparkAttractionMaintenance> aquaparkAttractionMaintenances;
}
