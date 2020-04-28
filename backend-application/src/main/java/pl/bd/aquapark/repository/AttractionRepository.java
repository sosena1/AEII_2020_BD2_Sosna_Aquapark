package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.AquaparkAttraction;

@Repository
public interface AttractionRepository extends PagingAndSortingRepository<AquaparkAttraction, Long> {

}
