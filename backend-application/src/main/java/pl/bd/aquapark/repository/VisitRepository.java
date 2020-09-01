package pl.bd.aquapark.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.Visit;

import java.util.List;

@Repository
public interface VisitRepository extends PagingAndSortingRepository<Visit, Long> {

    @Query(value = "select * from aquapark_db.visit a where date=?1", nativeQuery = true) //mysql to dziadostwo ze strefami czasowymi, super workaround
    List<Visit> findAllByDate(String date);
}
