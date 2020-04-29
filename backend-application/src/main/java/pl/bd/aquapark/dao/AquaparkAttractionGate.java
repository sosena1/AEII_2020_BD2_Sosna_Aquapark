package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AquaparkAttractionGate")
public @Data
class AquaparkAttractionGate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gateId")
    private Long gateId;

    @OneToMany
    @JoinColumn(name = "gateId")
    private List<AquaparkAttractionGateEvent> aquaparkAttractionGateEvents;

    @ManyToOne
    private AquaparkAttraction aquaparkAttraction;

}
