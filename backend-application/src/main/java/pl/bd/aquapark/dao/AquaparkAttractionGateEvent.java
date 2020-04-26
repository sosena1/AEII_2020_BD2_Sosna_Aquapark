package pl.bd.aquapark.dao;

import lombok.Data;
import org.hibernate.annotations.Type;

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
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isEntering;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "gateId")
    private Long gateId;

    @Column(name = "identificatorId")
    private Long clientIdentificatorId;

    @ManyToOne
    private ClientIdentificator clientIdentificator;

    @ManyToOne
    private AquaparkAttractionGate aquaparkAttractionGate;

    @OneToOne(mappedBy = "enteringEvent")
    private AquaparkAttractionUsage aquaparkAttractionUsageEntering;

    @OneToOne(mappedBy = "leavingEvent")
    private AquaparkAttractionUsage aquaparkAttractionUsageLeaving;

    public AquaparkAttractionUsage getCorrectEvent() {
        if (isEntering) {
            return aquaparkAttractionUsageEntering;
        } else {
            return aquaparkAttractionUsageLeaving;
        }
    }
}
