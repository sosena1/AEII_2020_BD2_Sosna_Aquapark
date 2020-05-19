package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "pricelist")
public @Data class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricelistid")
    private Long priceListId;

    @Column(name = "validitystartdate")
    private Date validityStartDate;

    @OneToMany
    @JoinColumn(name = "pricelistid")
    private List<PriceListItem> priceListItems;

    @ManyToOne
    private Employee employee;
}
