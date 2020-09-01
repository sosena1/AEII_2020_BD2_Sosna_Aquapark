package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "visit")
public
class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visitid", nullable = false)
    private Long visitId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "starttime", nullable = false)
    private Time startTime;

    @Column(name = "endtime", nullable = false)
    private Time endTime;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @OneToMany
    @JoinColumn(name = "visitid")
    private List<AquaparkAttractionUsage> aquaparkAttractionUsages;

    @ManyToOne
    @JoinColumn(name = "identificatorid")
    private ClientIdentificator clientIdentificator;

    public Visit() {
    }

    public boolean getHasEnded() {
        return endTime != null;
    }

    public Long getIdentificatorId() {
        return clientIdentificator.getIdentificatorId();
    }

    public Long getVisitId() {
        return this.visitId;
    }

    public Date getDate() {
        return this.date;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public Time getEndTime() {
        return this.endTime;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public Client getClient() {
        return this.client;
    }

    public List<AquaparkAttractionUsage> getAquaparkAttractionUsages() {
        return this.aquaparkAttractionUsages;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAquaparkAttractionUsages(List<AquaparkAttractionUsage> aquaparkAttractionUsages) {
        this.aquaparkAttractionUsages = aquaparkAttractionUsages;
    }

    public void setClientIdentificator(ClientIdentificator clientIdentificator) {
        this.clientIdentificator = clientIdentificator;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Visit)) return false;
        final Visit other = (Visit) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$visitId = this.getVisitId();
        final Object other$visitId = other.getVisitId();
        if (this$visitId == null ? other$visitId != null : !this$visitId.equals(other$visitId)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$startTime = this.getStartTime();
        final Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) return false;
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
        final Object this$client = this.getClient();
        final Object other$client = other.getClient();
        if (this$client == null ? other$client != null : !this$client.equals(other$client)) return false;
        final Object this$aquaparkAttractionUsages = this.getAquaparkAttractionUsages();
        final Object other$aquaparkAttractionUsages = other.getAquaparkAttractionUsages();
        if (this$aquaparkAttractionUsages == null ? other$aquaparkAttractionUsages != null : !this$aquaparkAttractionUsages.equals(other$aquaparkAttractionUsages))
            return false;
        final Object this$clientIdentificator = this.getClientIdentificator();
        final Object other$clientIdentificator = other.getClientIdentificator();
        if (this$clientIdentificator == null ? other$clientIdentificator != null : !this$clientIdentificator.equals(other$clientIdentificator))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Visit;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $visitId = this.getVisitId();
        result = result * PRIME + ($visitId == null ? 43 : $visitId.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $startTime = this.getStartTime();
        result = result * PRIME + ($startTime == null ? 43 : $startTime.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        final Object $client = this.getClient();
        result = result * PRIME + ($client == null ? 43 : $client.hashCode());
        final Object $aquaparkAttractionUsages = this.getAquaparkAttractionUsages();
        result = result * PRIME + ($aquaparkAttractionUsages == null ? 43 : $aquaparkAttractionUsages.hashCode());
        final Object $clientIdentificator = this.getClientIdentificator();
        result = result * PRIME + ($clientIdentificator == null ? 43 : $clientIdentificator.hashCode());
        return result;
    }

    public String toString() {
        return "Visit(visitId=" + this.getVisitId() + ", date=" + this.getDate() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", value=" + this.getValue() + ", client=" + this.getClient() + ", aquaparkAttractionUsages=" + this.getAquaparkAttractionUsages() + ", clientIdentificator=" + this.getClientIdentificator() + ")";
    }

    @JsonIgnore
    public ClientIdentificator getClientIdentificator() {
        return this.clientIdentificator;
    }
}
