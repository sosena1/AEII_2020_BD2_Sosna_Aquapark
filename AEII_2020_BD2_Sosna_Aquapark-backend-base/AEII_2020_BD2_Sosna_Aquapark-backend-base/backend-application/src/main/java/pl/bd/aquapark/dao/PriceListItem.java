package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pricelistitem")
public @Data
class PriceListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricelistitemid")
    private Long priceListItemId;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "conditionalid")
    private Conditions conditions;

    @ManyToOne
    @JoinColumn(name = "pricelistid")
    @Getter(onMethod = @__( @JsonIgnore))
    private PriceList priceList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attractionid")
    private AquaparkAttraction aquaparkAttraction;

    @OneToMany
    @JoinColumn(name = "usageid")
    @Getter(onMethod = @__( @JsonIgnore))
    private List<AquaparkAttractionUsage> aquaparkAttractionUsage;
}
