package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.AquaparkAttractionUsage;


@Repository
public interface AquaparkAttractionUsageRepository extends PagingAndSortingRepository<AquaparkAttractionUsage, Long> {
}
