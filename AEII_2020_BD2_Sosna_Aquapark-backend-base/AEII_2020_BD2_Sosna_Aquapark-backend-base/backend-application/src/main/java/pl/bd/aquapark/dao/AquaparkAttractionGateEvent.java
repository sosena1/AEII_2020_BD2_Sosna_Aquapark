package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "aquaparkattractiongateevent")
public @Data
class AquaparkAttractionGateEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventid")
    private Long eventId;

    @Column(name = "isentering")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isEntering;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "identificatorid")
    @Getter(onMethod = @__( @JsonIgnore))
    private ClientIdentificator clientIdentificator;

    @ManyToOne
    @JoinColumn(name = "gateid")
    @Getter(onMethod = @__( @JsonIgnore))
    private AquaparkAttractionGate aquaparkAttractionGate;

    @Getter(onMethod = @__( @JsonIgnore))
    @OneToOne(mappedBy = "enteringEvent")
    private AquaparkAttractionUsage aquaparkAttractionUsageEntering;

    @Getter(onMethod = @__( @JsonIgnore))
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
