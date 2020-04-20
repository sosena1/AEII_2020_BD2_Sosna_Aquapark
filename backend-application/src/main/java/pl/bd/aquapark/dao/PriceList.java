package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "PriceList")
public @Data class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "priceListId")
    private Long priceListId;

    @Column(name = "validityStartDate")
    private Date validityStartDate;

    @OneToMany
    @JoinColumn(name = "priceListId")
    private List<PriceListItem> priceListItems;

    @ManyToOne
    private Employee employee;
}
