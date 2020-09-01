package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.AquaparkAttractionGateEvent;


@Repository
public interface AquaparkGateEventRepository extends PagingAndSortingRepository<AquaparkAttractionGateEvent, Long> {
}
