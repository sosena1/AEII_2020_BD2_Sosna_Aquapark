package pl.bd.aquapark.dao;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

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
    private List<Visit> visit;

    @OneToMany
    @JoinColumn(name = "identificatorId")
    private List<AquaparkAttractionGateEvent> aquaparkAttractionGateEvents;

}
