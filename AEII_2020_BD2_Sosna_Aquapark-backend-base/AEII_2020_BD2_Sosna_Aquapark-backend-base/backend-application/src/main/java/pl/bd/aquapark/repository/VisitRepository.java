package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.User;
import pl.bd.aquapark.dao.Visit;

import java.sql.Date;
import java.util.List;

@Repository
public interface VisitRepository extends PagingAndSortingRepository<Visit, Long> {

    List<Visit> findAllByDate(Date date);
}
