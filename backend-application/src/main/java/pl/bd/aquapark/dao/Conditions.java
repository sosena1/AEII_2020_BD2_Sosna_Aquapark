package pl.bd.aquapark.dao;

import lombok.Data;
import org.hibernate.annotations.Type;

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
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean weekendOnly;

    @Column(name = "childOnly")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean childOnly;

    @Column(name = "seniorOnly")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean seniorOnly;

    @OneToMany
    @JoinColumn(name = "conditionalId")
    private List<PriceListItem> priceListItemList;
}
