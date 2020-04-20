package pl.bd.aquapark.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Conditions")
public @Data
class Conditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conditionId")
    private Long conditionId;

    @Column(name = "weekendOnly")
    private Boolean weekendOnly;

    @Column(name = "childOnly")
    private Boolean childOnly;

    @Column(name = "seniorOnly")
    private Boolean seniorOnly;

    @OneToMany
    @JoinColumn(name = "conditionalId")
    private List<PriceListItem> priceListItemList;
}
