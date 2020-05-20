package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "aquaparkattractionusage")
public @Data
class AquaparkAttractionUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usageid")
    private Long usageId;

    @ManyToOne
    @JoinColumn(name = "visitid")
    @Getter(onMethod = @__( @JsonIgnore))
    private Visit visit;

    @ManyToOne
    @JoinColumn(name = "attractionid")
    @Getter(onMethod = @__( @JsonIgnore)) //can be seen in pricelistitem
    private AquaparkAttraction aquaparkAttraction;

    @ManyToOne
    @JoinColumn(name = "pricelistitemid")
    private PriceListItem priceListItem;

    @OneToOne(optional = false)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumn(name = "enteringeventid")
    private AquaparkAttractionGateEvent enteringEvent;

    @OneToOne(optional = true)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumn(name = "leavingeventid")
    private AquaparkAttractionGateEvent leavingEvent;

    public long getTimeSpendInMinutes() {
        if (leavingEvent == null) return -1;
        Time enteringTime = enteringEvent.getTime();
        Time leavingTime = leavingEvent.getTime();
        LocalTime from = leavingTime.toLocalTime();
        LocalTime to = enteringTime.toLocalTime();

        Duration d = Duration.between(from, to);
        return d.toMinutes();
    }

    public Time getEnteringTime() {
        return enteringEvent.getTime();
    }

    public Time getLeavingTime() {
        if (leavingEvent == null) return null;
        return leavingEvent.getTime();
    }
}
