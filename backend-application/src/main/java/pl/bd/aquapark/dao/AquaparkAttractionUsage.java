package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AquaparkAttractionUsage")
public @Data
class AquaparkAttractionUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usageId")
    private Long usageId;

    @ManyToOne
    private Visit visit;

    @ManyToOne
    private AquaparkAttraction aquaparkAttraction;

    @OneToMany
    @JoinColumn(name = "usageId")
    private List<PriceListItem> priceListItems;

    @OneToOne(optional = false)
    @JoinColumn(name = "eventId", referencedColumnName = "enteringEventId") //todo tu i poniżej mam watpliwosci co do mapowania!
    private AquaparkAttractionGateEvent enteringEvent;

    @OneToOne(optional = true)
    @JoinColumn(name = "eventId", referencedColumnName = "leavingEventId")
    private AquaparkAttractionGateEvent leavingEvent;


}
