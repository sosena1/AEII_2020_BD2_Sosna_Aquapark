package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public
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
    private List<Visit> visits;

    public Client() {
    }

    public List<Long> getVisitsId() {
        if (visits == null) {
            return new ArrayList<>();
        }
        List<Long> integers = new ArrayList<>();
        for (Visit visit : visits) {
            integers.add(visit.getVisitId());
        }
        return integers;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                '}';
    }

    public Long getClientId() {
        if (this.clientId == null) {
            return -1L;
        }
        return this.clientId;
    }

    public Boolean getOwnsAccount() {
        return this.ownsAccount;
    }

    public User getUser() {
        return this.user;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setOwnsAccount(Boolean ownsAccount) {
        this.ownsAccount = ownsAccount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Client)) return false;
        final Client other = (Client) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$clientId = this.getClientId();
        final Object other$clientId = other.getClientId();
        if (this$clientId == null ? other$clientId != null : !this$clientId.equals(other$clientId)) return false;
        final Object this$ownsAccount = this.getOwnsAccount();
        final Object other$ownsAccount = other.getOwnsAccount();
        if (this$ownsAccount == null ? other$ownsAccount != null : !this$ownsAccount.equals(other$ownsAccount))
            return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$visits = this.getVisits();
        final Object other$visits = other.getVisits();
        if (this$visits == null ? other$visits != null : !this$visits.equals(other$visits)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Client;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $clientId = this.getClientId();
        result = result * PRIME + ($clientId == null ? 43 : $clientId.hashCode());
        final Object $ownsAccount = this.getOwnsAccount();
        result = result * PRIME + ($ownsAccount == null ? 43 : $ownsAccount.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $visits = this.getVisits();
        result = result * PRIME + ($visits == null ? 43 : $visits.hashCode());
        return result;
    }

    @JsonIgnore
    public List<Visit> getVisits() {
        return this.visits;
    }
}
