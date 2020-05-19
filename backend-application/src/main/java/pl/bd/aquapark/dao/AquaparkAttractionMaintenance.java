package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "aquaparkattractionmaintenance")
public @Data class AquaparkAttractionMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attractionmaintenanceid")
    private Long attractionMaintenanceId;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private AquaparkAttraction aquaparkAttraction;
}
