package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.AquaparkAttractionGate;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;


@Repository
public interface AquaparkAttractionGateRepository extends PagingAndSortingRepository<AquaparkAttractionGate, Long> {
}
