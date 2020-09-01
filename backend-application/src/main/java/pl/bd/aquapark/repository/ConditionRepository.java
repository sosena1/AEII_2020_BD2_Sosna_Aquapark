package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.Conditions;

@Repository
public interface ConditionRepository extends PagingAndSortingRepository<Conditions, Long> {
}
