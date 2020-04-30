package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PriceListItem")
public @Data
class PriceListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "priceListItemId")
    private Long priceListItemId;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Conditions conditions;

    @ManyToOne
    private PriceList priceList;

    @ManyToOne
    private AquaparkAttraction aquaparkAttraction;

    @OneToMany
    @JoinColumn(name = "usageId")
    private List<AquaparkAttractionUsage> aquaparkAttractionUsage;
}
