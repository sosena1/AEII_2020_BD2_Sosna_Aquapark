package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
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

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @OneToMany
    @JoinColumn(name = "clientid")
    @Getter(onMethod = @__( @JsonIgnore))
    private List<Visit> visits;

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                '}';
    }
}
