package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "aquaparkattractiongateevent")
public
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
    private ClientIdentificator clientIdentificator;

    @ManyToOne
    @JoinColumn(name = "gateid")
    private AquaparkAttractionGate aquaparkAttractionGate;

    @OneToOne(mappedBy = "enteringEvent")
    private AquaparkAttractionUsage aquaparkAttractionUsageEntering;

    @OneToOne(mappedBy = "leavingEvent")
    private AquaparkAttractionUsage aquaparkAttractionUsageLeaving;

    public AquaparkAttractionGateEvent() {
    }


    public AquaparkAttractionUsage getCorrectEvent() {
        if (isEntering) {
            return aquaparkAttractionUsageEntering;
        } else {
            return aquaparkAttractionUsageLeaving;
        }
    }

    public Long getEventId() {
        return this.eventId;
    }

    public boolean isEntering() {
        return this.isEntering;
    }

    public Date getDate() {
        return this.date;
    }

    public Time getTime() {
        return this.time;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setEntering(boolean isEntering) {
        this.isEntering = isEntering;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setClientIdentificator(ClientIdentificator clientIdentificator) {
        this.clientIdentificator = clientIdentificator;
    }

    public void setAquaparkAttractionGate(AquaparkAttractionGate aquaparkAttractionGate) {
        this.aquaparkAttractionGate = aquaparkAttractionGate;
    }

    public void setAquaparkAttractionUsageEntering(AquaparkAttractionUsage aquaparkAttractionUsageEntering) {
        this.aquaparkAttractionUsageEntering = aquaparkAttractionUsageEntering;
    }

    public void setAquaparkAttractionUsageLeaving(AquaparkAttractionUsage aquaparkAttractionUsageLeaving) {
        this.aquaparkAttractionUsageLeaving = aquaparkAttractionUsageLeaving;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AquaparkAttractionGateEvent)) return false;
        final AquaparkAttractionGateEvent other = (AquaparkAttractionGateEvent) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$eventId = this.getEventId();
        final Object other$eventId = other.getEventId();
        if (this$eventId == null ? other$eventId != null : !this$eventId.equals(other$eventId)) return false;
        if (this.isEntering() != other.isEntering()) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$time = this.getTime();
        final Object other$time = other.getTime();
        if (this$time == null ? other$time != null : !this$time.equals(other$time)) return false;
        final Object this$clientIdentificator = this.getClientIdentificator();
        final Object other$clientIdentificator = other.getClientIdentificator();
        if (this$clientIdentificator == null ? other$clientIdentificator != null : !this$clientIdentificator.equals(other$clientIdentificator))
            return false;
        final Object this$aquaparkAttractionGate = this.getAquaparkAttractionGate();
        final Object other$aquaparkAttractionGate = other.getAquaparkAttractionGate();
        if (this$aquaparkAttractionGate == null ? other$aquaparkAttractionGate != null : !this$aquaparkAttractionGate.equals(other$aquaparkAttractionGate))
            return false;
        final Object this$aquaparkAttractionUsageEntering = this.getAquaparkAttractionUsageEntering();
        final Object other$aquaparkAttractionUsageEntering = other.getAquaparkAttractionUsageEntering();
        if (this$aquaparkAttractionUsageEntering == null ? other$aquaparkAttractionUsageEntering != null : !this$aquaparkAttractionUsageEntering.equals(other$aquaparkAttractionUsageEntering))
            return false;
        final Object this$aquaparkAttractionUsageLeaving = this.getAquaparkAttractionUsageLeaving();
        final Object other$aquaparkAttractionUsageLeaving = other.getAquaparkAttractionUsageLeaving();
        if (this$aquaparkAttractionUsageLeaving == null ? other$aquaparkAttractionUsageLeaving != null : !this$aquaparkAttractionUsageLeaving.equals(other$aquaparkAttractionUsageLeaving))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AquaparkAttractionGateEvent;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $eventId = this.getEventId();
        result = result * PRIME + ($eventId == null ? 43 : $eventId.hashCode());
        result = result * PRIME + (this.isEntering() ? 79 : 97);
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $time = this.getTime();
        result = result * PRIME + ($time == null ? 43 : $time.hashCode());
        final Object $clientIdentificator = this.getClientIdentificator();
        result = result * PRIME + ($clientIdentificator == null ? 43 : $clientIdentificator.hashCode());
        final Object $aquaparkAttractionGate = this.getAquaparkAttractionGate();
        result = result * PRIME + ($aquaparkAttractionGate == null ? 43 : $aquaparkAttractionGate.hashCode());
        final Object $aquaparkAttractionUsageEntering = this.getAquaparkAttractionUsageEntering();
        result = result * PRIME + ($aquaparkAttractionUsageEntering == null ? 43 : $aquaparkAttractionUsageEntering.hashCode());
        final Object $aquaparkAttractionUsageLeaving = this.getAquaparkAttractionUsageLeaving();
        result = result * PRIME + ($aquaparkAttractionUsageLeaving == null ? 43 : $aquaparkAttractionUsageLeaving.hashCode());
        return result;
    }

    public String toString() {
        return "AquaparkAttractionGateEvent(eventId=" + this.getEventId() + ", isEntering=" + this.isEntering() + ", date=" + this.getDate() + ", time=" + this.getTime() + ", clientIdentificator=" + this.getClientIdentificator() + ", aquaparkAttractionGate=" + this.getAquaparkAttractionGate() + ", aquaparkAttractionUsageEntering=" + this.getAquaparkAttractionUsageEntering() + ", aquaparkAttractionUsageLeaving=" + this.getAquaparkAttractionUsageLeaving() + ")";
    }

    @JsonIgnore
    public ClientIdentificator getClientIdentificator() {
        return this.clientIdentificator;
    }

    @JsonIgnore
    public AquaparkAttractionGate getAquaparkAttractionGate() {
        return this.aquaparkAttractionGate;
    }

    @JsonIgnore
    public AquaparkAttractionUsage getAquaparkAttractionUsageEntering() {
        return this.aquaparkAttractionUsageEntering;
    }

    @JsonIgnore
    public AquaparkAttractionUsage getAquaparkAttractionUsageLeaving() {
        return this.aquaparkAttractionUsageLeaving;
    }
}
