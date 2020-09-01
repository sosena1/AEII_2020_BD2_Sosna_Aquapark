package pl.bd.aquapark.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aquaparkattractiongate")
public
class AquaparkAttractionGate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gateid")
    private Long gateId;

    @OneToMany
    @JoinColumn(name = "gateid")
    private List<AquaparkAttractionGateEvent> aquaparkAttractionGateEvents;

    @ManyToOne
    @JoinColumn(name = "attractionid")
    private AquaparkAttraction aquaparkAttraction;

    public AquaparkAttractionGate() {
    }

    public Long getGateId() {
        return this.gateId;
    }

    public List<AquaparkAttractionGateEvent> getAquaparkAttractionGateEvents() {
        return this.aquaparkAttractionGateEvents;
    }

    public AquaparkAttraction getAquaparkAttraction() {
        return this.aquaparkAttraction;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public void setAquaparkAttractionGateEvents(List<AquaparkAttractionGateEvent> aquaparkAttractionGateEvents) {
        this.aquaparkAttractionGateEvents = aquaparkAttractionGateEvents;
    }

    public void setAquaparkAttraction(AquaparkAttraction aquaparkAttraction) {
        this.aquaparkAttraction = aquaparkAttraction;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AquaparkAttractionGate)) return false;
        final AquaparkAttractionGate other = (AquaparkAttractionGate) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$gateId = this.getGateId();
        final Object other$gateId = other.getGateId();
        if (this$gateId == null ? other$gateId != null : !this$gateId.equals(other$gateId)) return false;
        final Object this$aquaparkAttractionGateEvents = this.getAquaparkAttractionGateEvents();
        final Object other$aquaparkAttractionGateEvents = other.getAquaparkAttractionGateEvents();
        if (this$aquaparkAttractionGateEvents == null ? other$aquaparkAttractionGateEvents != null : !this$aquaparkAttractionGateEvents.equals(other$aquaparkAttractionGateEvents))
            return false;
        final Object this$aquaparkAttraction = this.getAquaparkAttraction();
        final Object other$aquaparkAttraction = other.getAquaparkAttraction();
        if (this$aquaparkAttraction == null ? other$aquaparkAttraction != null : !this$aquaparkAttraction.equals(other$aquaparkAttraction))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AquaparkAttractionGate;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $gateId = this.getGateId();
        result = result * PRIME + ($gateId == null ? 43 : $gateId.hashCode());
        final Object $aquaparkAttractionGateEvents = this.getAquaparkAttractionGateEvents();
        result = result * PRIME + ($aquaparkAttractionGateEvents == null ? 43 : $aquaparkAttractionGateEvents.hashCode());
        final Object $aquaparkAttraction = this.getAquaparkAttraction();
        result = result * PRIME + ($aquaparkAttraction == null ? 43 : $aquaparkAttraction.hashCode());
        return result;
    }

    public String toString() {
        return "AquaparkAttractionGate(gateId=" + this.getGateId() + ", aquaparkAttractionGateEvents=" + this.getAquaparkAttractionGateEvents() + ", aquaparkAttraction=" + this.getAquaparkAttraction() + ")";
    }
}
