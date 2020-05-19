package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "visit")
public @Data
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
    private Client client;

    @OneToMany
    @JoinColumn(name = "visitid")
    private List<AquaparkAttractionUsage> aquaparkAttractionUsages;

    @ManyToOne
    private ClientIdentificator clientIdentificator;
}
