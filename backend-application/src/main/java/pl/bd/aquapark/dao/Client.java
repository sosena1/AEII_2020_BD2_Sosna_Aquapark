package pl.bd.aquapark.dao;

import lombok.Data;

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
    private Boolean ownsAccount;

    @OneToOne(mappedBy = "client")
    private User user;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Visit> visits;

}
