package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
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

    @ManyToOne
    private PriceListItem priceListItem;

    @OneToOne(optional = false)
    @JoinColumn(name = "enteringEventId", referencedColumnName = "eventId")
    private AquaparkAttractionGateEvent enteringEvent;

    @OneToOne(optional = true)
    @JoinColumn(name = "leavingEventId", referencedColumnName = "eventId")
    private AquaparkAttractionGateEvent leavingEvent;


    public long getTimeSpendInMinutes() {
        Time enteringTime = enteringEvent.getTime();
        Time leavingTime = leavingEvent.getTime();
        LocalTime from = leavingTime.toLocalTime();
        LocalTime to = enteringTime.toLocalTime();

        Duration d = Duration.between(from, to);
        return d.toMinutes();
    }
}
