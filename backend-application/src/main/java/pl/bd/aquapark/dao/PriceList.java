package pl.bd.aquapark.dao;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "pricelist")
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricelistid")
    private Long priceListId;

    @Column(name = "validitystartdate")
    private Date validityStartDate;

    @OneToMany
    @JoinColumn(name = "pricelistid")
    private List<PriceListItem> priceListItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeid")
    private Employee employee;

    public PriceList() {
    }

    public Long getPriceListId() {
        return this.priceListId;
    }

    public Date getValidityStartDate() {
        return this.validityStartDate;
    }

    public List<PriceListItem> getPriceListItems() {
        return this.priceListItems;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public void setValidityStartDate(Date validityStartDate) {
        this.validityStartDate = validityStartDate;
    }

    public void setPriceListItems(List<PriceListItem> priceListItems) {
        this.priceListItems = priceListItems;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PriceList)) return false;
        final PriceList other = (PriceList) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$priceListId = this.getPriceListId();
        final Object other$priceListId = other.getPriceListId();
        if (this$priceListId == null ? other$priceListId != null : !this$priceListId.equals(other$priceListId))
            return false;
        final Object this$validityStartDate = this.getValidityStartDate();
        final Object other$validityStartDate = other.getValidityStartDate();
        if (this$validityStartDate == null ? other$validityStartDate != null : !this$validityStartDate.equals(other$validityStartDate))
            return false;
        final Object this$priceListItems = this.getPriceListItems();
        final Object other$priceListItems = other.getPriceListItems();
        if (this$priceListItems == null ? other$priceListItems != null : !this$priceListItems.equals(other$priceListItems))
            return false;
        final Object this$employee = this.getEmployee();
        final Object other$employee = other.getEmployee();
        if (this$employee == null ? other$employee != null : !this$employee.equals(other$employee)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PriceList;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $priceListId = this.getPriceListId();
        result = result * PRIME + ($priceListId == null ? 43 : $priceListId.hashCode());
        final Object $validityStartDate = this.getValidityStartDate();
        result = result * PRIME + ($validityStartDate == null ? 43 : $validityStartDate.hashCode());
        final Object $priceListItems = this.getPriceListItems();
        result = result * PRIME + ($priceListItems == null ? 43 : $priceListItems.hashCode());
        final Object $employee = this.getEmployee();
        result = result * PRIME + ($employee == null ? 43 : $employee.hashCode());
        return result;
    }

    public String toString() {
        return "PriceList(priceListId=" + this.getPriceListId() + ", validityStartDate=" + this.getValidityStartDate() + ", priceListItems=" + this.getPriceListItems() + ", employee=" + this.getEmployee() + ")";
    }
}
