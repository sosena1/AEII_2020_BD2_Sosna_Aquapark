package pl.bd.aquapark.dao;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Client")
public @Data
class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId", nullable = false)
    private Long clientId;

    @Column(name = "ownsAccount")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean ownsAccount;

    @OneToOne(mappedBy = "client")
    private User user;

    @OneToMany
    @JoinColumn(name = "clientId")
    private List<Visit> visits;

}
