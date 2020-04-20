package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "Visit")
public @Data
class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visitId", nullable = false)
    private Long visitId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "startTime", nullable = false)
    private Time startTime;

    @Column(name = "endTime", nullable = false)
    private Time endTime;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    private Client client;

    @OneToMany
    @JoinColumn(name = "visitId")
    private List<AquaparkAttractionUsage> aquaparkAttractionUsages;

    @ManyToOne
    private ClientIdentificator clientIdentificator;
}
