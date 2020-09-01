package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "clientidentificator")
public
class ClientIdentificator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificatorid")
    private Long identificatorId;

    @Column(name = "isinuse")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isInUse;

    @OneToMany
    @JoinColumn(name = "identificatorid")
    private List<Visit> visits;

    @OneToMany
    @JoinColumn(name = "identificatorid")
    private List<AquaparkAttractionGateEvent> aquaparkAttractionGateEvents;

    public ClientIdentificator() {
    }

    @JsonIgnore
    public Visit getActiveVisit() {
        List<Visit> unendedVisits = visits.stream()
                .filter(visit -> !visit.getHasEnded())
                .collect(Collectors.toList());
        if (unendedVisits.size() != 1) {
            throw new IllegalArgumentException("Cannot get 1 active visit, since there are " + unendedVisits.size() + " active visits! Visits size " + visits.size());
        }
        return unendedVisits.get(0);
    }

    public Long getIdentificatorId() {
        return this.identificatorId;
    }

    public Boolean getIsInUse() {
        return this.isInUse;
    }

    public void setIdentificatorId(Long identificatorId) {
        this.identificatorId = identificatorId;
    }

    public void setIsInUse(Boolean isInUse) {
        this.isInUse = isInUse;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public void setAquaparkAttractionGateEvents(List<AquaparkAttractionGateEvent> aquaparkAttractionGateEvents) {
        this.aquaparkAttractionGateEvents = aquaparkAttractionGateEvents;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ClientIdentificator)) return false;
        final ClientIdentificator other = (ClientIdentificator) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$identificatorId = this.getIdentificatorId();
        final Object other$identificatorId = other.getIdentificatorId();
        if (this$identificatorId == null ? other$identificatorId != null : !this$identificatorId.equals(other$identificatorId))
            return false;
        final Object this$isInUse = this.getIsInUse();
        final Object other$isInUse = other.getIsInUse();
        if (this$isInUse == null ? other$isInUse != null : !this$isInUse.equals(other$isInUse)) return false;
        final Object this$visits = this.getVisits();
        final Object other$visits = other.getVisits();
        if (this$visits == null ? other$visits != null : !this$visits.equals(other$visits)) return false;
        final Object this$aquaparkAttractionGateEvents = this.getAquaparkAttractionGateEvents();
        final Object other$aquaparkAttractionGateEvents = other.getAquaparkAttractionGateEvents();
        if (this$aquaparkAttractionGateEvents == null ? other$aquaparkAttractionGateEvents != null : !this$aquaparkAttractionGateEvents.equals(other$aquaparkAttractionGateEvents))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ClientIdentificator;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $identificatorId = this.getIdentificatorId();
        result = result * PRIME + ($identificatorId == null ? 43 : $identificatorId.hashCode());
        final Object $isInUse = this.getIsInUse();
        result = result * PRIME + ($isInUse == null ? 43 : $isInUse.hashCode());
        final Object $visits = this.getVisits();
        result = result * PRIME + ($visits == null ? 43 : $visits.hashCode());
        final Object $aquaparkAttractionGateEvents = this.getAquaparkAttractionGateEvents();
        result = result * PRIME + ($aquaparkAttractionGateEvents == null ? 43 : $aquaparkAttractionGateEvents.hashCode());
        return result;
    }

    public String toString() {
        return "ClientIdentificator(identificatorId=" + this.getIdentificatorId() + ", isInUse=" + this.getIsInUse() + ", visits=" + this.getVisits() + ", aquaparkAttractionGateEvents=" + this.getAquaparkAttractionGateEvents() + ")";
    }

    @JsonIgnore
    public List<Visit> getVisits() {
        return this.visits;
    }

    @JsonIgnore
    public List<AquaparkAttractionGateEvent> getAquaparkAttractionGateEvents() {
        return this.aquaparkAttractionGateEvents;
    }
}
