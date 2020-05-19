package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aquaparkattractiongate")
public @Data
class AquaparkAttractionGate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gateid")
    private Long gateId;

    @OneToMany
    @JoinColumn(name = "gateid")
    private List<AquaparkAttractionGateEvent> aquaparkAttractionGateEvents;

    @ManyToOne
    private AquaparkAttraction aquaparkAttraction;

}
