package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.Gender;

@Repository
public interface GenderRepository extends PagingAndSortingRepository<Gender, Long> {

}
