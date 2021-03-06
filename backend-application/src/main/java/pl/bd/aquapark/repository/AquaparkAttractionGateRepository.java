package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.AquaparkAttractionGate;


@Repository
public interface AquaparkAttractionGateRepository extends PagingAndSortingRepository<AquaparkAttractionGate, Long> {
}
