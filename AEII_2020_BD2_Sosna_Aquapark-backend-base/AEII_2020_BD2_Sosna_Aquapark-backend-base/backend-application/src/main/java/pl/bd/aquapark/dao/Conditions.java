package pl.bd.aquapark.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conditions")
public @Data
class Conditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conditionid")
    private Long conditionId;

    @Column(name = "weekendonly")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean weekendOnly;

    @Column(name = "childonly")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean childOnly;

    @Column(name = "senioronly")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean seniorOnly;

    @OneToMany
    @JoinColumn(name = "conditionalid")
    @Getter(onMethod = @__( @JsonIgnore))
    private List<PriceListItem> priceListItemList;
}
