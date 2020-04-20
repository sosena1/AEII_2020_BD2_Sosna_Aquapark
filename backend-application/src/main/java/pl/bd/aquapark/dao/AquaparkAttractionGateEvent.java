package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "AquaparkAttractionGateEvent")
public @Data
class AquaparkAttractionGateEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId")
    private Long eventId;

    @Column(name = "isEntering")
    private boolean isEntering;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "gateId")
    private Long gateId;

    @Column(name = "clientIdentificatorId")
    private Long clientIdentificatorId;

    @ManyToOne
    private ClientIdentificator clientIdentificator;

    @ManyToOne
    private AquaparkAttractionGate aquaparkAttractionGate;
}
