package pl.bd.aquapark.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;

import java.util.List;

@Repository
public interface AttractionMaintenanceRepository extends PagingAndSortingRepository<AquaparkAttractionMaintenance, Long> {


    @Query(value = "select * from aquapark_db.aquaparkattractionmaintenance a where date=?1", nativeQuery = true) //mysql to dziadostwo ze strefami czasowymi, super workaround
    List<AquaparkAttractionMaintenance> findAllByDate(String date);

}
