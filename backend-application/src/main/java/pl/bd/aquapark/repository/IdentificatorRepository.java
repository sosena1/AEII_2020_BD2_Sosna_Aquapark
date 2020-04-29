package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.AquaparkAttractionGate;
import pl.bd.aquapark.dao.ClientIdentificator;


@Repository
public interface IdentificatorRepository extends PagingAndSortingRepository<ClientIdentificator, Long> {
}
