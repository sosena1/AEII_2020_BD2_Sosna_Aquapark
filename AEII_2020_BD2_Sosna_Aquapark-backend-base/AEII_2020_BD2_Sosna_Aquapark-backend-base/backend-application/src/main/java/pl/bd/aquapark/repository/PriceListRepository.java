package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.PriceList;
import pl.bd.aquapark.dao.User;

@Repository
public interface PriceListRepository extends PagingAndSortingRepository<PriceList, Long> {
}
