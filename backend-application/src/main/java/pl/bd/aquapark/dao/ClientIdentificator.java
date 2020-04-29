package pl.bd.aquapark.dao;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "ClientIdentificator")
public @Data
class ClientIdentificator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificatorId")
    private Long identificatorId;

    @Column(name = "isInUse")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isInUse;

    @OneToMany
    @JoinColumn(name = "identificatorId")
    private List<Visit> visits;

    @OneToMany
    @JoinColumn(name = "identificatorId")
    private List<AquaparkAttractionGateEvent> aquaparkAttractionGateEvents;

    public Visit getActiveVisit() {
        List<Visit> unendedVisits = visits.stream()
                .filter((Visit v) -> v.getEndTime() == null)
                .collect(Collectors.toList());
        if (unendedVisits.size() != 1) {
            throw new IllegalArgumentException("Cannot get active visit, since there are " + unendedVisits.size() + " active visits! ");
        }
        return unendedVisits.get(0);
    }
}
