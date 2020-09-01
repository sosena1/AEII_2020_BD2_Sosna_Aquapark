package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.PriceList;

@Repository
public interface PriceListRepository extends PagingAndSortingRepository<PriceList, Long> {
}
