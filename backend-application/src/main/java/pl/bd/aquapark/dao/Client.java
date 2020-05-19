package pl.bd.aquapark.dao;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public @Data
class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientid", nullable = false)
    private Long clientId;

    @Column(name = "ownsaccount")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean ownsAccount;

    @OneToOne(mappedBy = "client")
    private User user;

    @OneToMany
    @JoinColumn(name = "clientid")
    private List<Visit> visits;

}
