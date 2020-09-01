package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

@Entity
@Table(name = "aquaparkattractionusage")
public
class AquaparkAttractionUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usageid")
    private Long usageId;

    @ManyToOne
    @JoinColumn(name = "visitid")
    private Visit visit;

    @ManyToOne
    @JoinColumn(name = "attractionid")
    //can be seen in pricelistitem
    private AquaparkAttraction aquaparkAttraction;

    @ManyToOne
    @JoinColumn(name = "pricelistitemid")
    private PriceListItem priceListItem;

    @OneToOne(optional = false)
    @JoinColumn(name = "enteringeventid")
    private AquaparkAttractionGateEvent enteringEvent;

    @OneToOne(optional = true)
    @JoinColumn(name = "leavingeventid")
    private AquaparkAttractionGateEvent leavingEvent;

    public AquaparkAttractionUsage() {
    }

    public long getTimeSpendInMinutes() {
        if (leavingEvent == null) return -1;
        Time enteringTime = enteringEvent.getTime();
        Time leavingTime = leavingEvent.getTime();
        LocalTime from = leavingTime.toLocalTime();
        LocalTime to = enteringTime.toLocalTime();

        Duration d = Duration.between(to, from);
        return d.toMinutes();
    }

    public Time getEnteringTime() {
        return enteringEvent.getTime();
    }

    public Time getLeavingTime() {
        if (leavingEvent == null) return null;
        return leavingEvent.getTime();
    }

    public Long getUsageId() {
        return this.usageId;
    }

    public PriceListItem getPriceListItem() {
        return this.priceListItem;
    }

    public void setUsageId(Long usageId) {
        this.usageId = usageId;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public void setAquaparkAttraction(AquaparkAttraction aquaparkAttraction) {
        this.aquaparkAttraction = aquaparkAttraction;
    }

    public void setPriceListItem(PriceListItem priceListItem) {
        this.priceListItem = priceListItem;
    }

    public void setEnteringEvent(AquaparkAttractionGateEvent enteringEvent) {
        this.enteringEvent = enteringEvent;
    }

    public void setLeavingEvent(AquaparkAttractionGateEvent leavingEvent) {
        this.leavingEvent = leavingEvent;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AquaparkAttractionUsage)) return false;
        final AquaparkAttractionUsage other = (AquaparkAttractionUsage) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$usageId = this.getUsageId();
        final Object other$usageId = other.getUsageId();
        if (this$usageId == null ? other$usageId != null : !this$usageId.equals(other$usageId)) return false;
        final Object this$visit = this.getVisit();
        final Object other$visit = other.getVisit();
        if (this$visit == null ? other$visit != null : !this$visit.equals(other$visit)) return false;
        final Object this$aquaparkAttraction = this.getAquaparkAttraction();
        final Object other$aquaparkAttraction = other.getAquaparkAttraction();
        if (this$aquaparkAttraction == null ? other$aquaparkAttraction != null : !this$aquaparkAttraction.equals(other$aquaparkAttraction))
            return false;
        final Object this$priceListItem = this.getPriceListItem();
        final Object other$priceListItem = other.getPriceListItem();
        if (this$priceListItem == null ? other$priceListItem != null : !this$priceListItem.equals(other$priceListItem))
            return false;
        final Object this$enteringEvent = this.getEnteringEvent();
        final Object other$enteringEvent = other.getEnteringEvent();
        if (this$enteringEvent == null ? other$enteringEvent != null : !this$enteringEvent.equals(other$enteringEvent))
            return false;
        final Object this$leavingEvent = this.getLeavingEvent();
        final Object other$leavingEvent = other.getLeavingEvent();
        if (this$leavingEvent == null ? other$leavingEvent != null : !this$leavingEvent.equals(other$leavingEvent))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AquaparkAttractionUsage;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $usageId = this.getUsageId();
        result = result * PRIME + ($usageId == null ? 43 : $usageId.hashCode());
        final Object $visit = this.getVisit();
        result = result * PRIME + ($visit == null ? 43 : $visit.hashCode());
        final Object $aquaparkAttraction = this.getAquaparkAttraction();
        result = result * PRIME + ($aquaparkAttraction == null ? 43 : $aquaparkAttraction.hashCode());
        final Object $priceListItem = this.getPriceListItem();
        result = result * PRIME + ($priceListItem == null ? 43 : $priceListItem.hashCode());
        final Object $enteringEvent = this.getEnteringEvent();
        result = result * PRIME + ($enteringEvent == null ? 43 : $enteringEvent.hashCode());
        final Object $leavingEvent = this.getLeavingEvent();
        result = result * PRIME + ($leavingEvent == null ? 43 : $leavingEvent.hashCode());
        return result;
    }

    public String toString() {
        return "AquaparkAttractionUsage(usageId=" + this.getUsageId() + ", visit=" + this.getVisit() + ", aquaparkAttraction=" + this.getAquaparkAttraction() + ", priceListItem=" + this.getPriceListItem() + ", enteringEvent=" + this.getEnteringEvent() + ", leavingEvent=" + this.getLeavingEvent() + ")";
    }

    @JsonIgnore
    public Visit getVisit() {
        return this.visit;
    }

    @JsonIgnore
    public AquaparkAttraction getAquaparkAttraction() {
        return this.aquaparkAttraction;
    }

    @JsonIgnore
    public AquaparkAttractionGateEvent getEnteringEvent() {
        return this.enteringEvent;
    }

    @JsonIgnore
    public AquaparkAttractionGateEvent getLeavingEvent() {
        return this.leavingEvent;
    }
}
