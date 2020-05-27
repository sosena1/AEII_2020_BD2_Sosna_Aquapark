package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "clientidentificator")
public @Data
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
    @Getter(onMethod = @__( @JsonIgnore))
    private List<Visit> visits;

    @OneToMany
    @JoinColumn(name = "identificatorid")
    @Getter(onMethod = @__( @JsonIgnore))
    private List<AquaparkAttractionGateEvent> aquaparkAttractionGateEvents;

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
}
