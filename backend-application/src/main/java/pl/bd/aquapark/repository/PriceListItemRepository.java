package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.PriceList;
import pl.bd.aquapark.dao.PriceListItem;

@Repository
public interface PriceListItemRepository extends PagingAndSortingRepository<PriceListItem, Long> {
}
