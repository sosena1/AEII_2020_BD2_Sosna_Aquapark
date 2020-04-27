package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.Gender;
import pl.bd.aquapark.dao.Visit;

@Repository
public interface GenderRepository extends PagingAndSortingRepository<Gender, Long> {

}
