package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.AquaparkAttraction;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;

import java.sql.Date;
import java.util.List;

@Repository
public interface AttractionMaintenanceRepository extends PagingAndSortingRepository<AquaparkAttractionMaintenance, Long> {
    List<AquaparkAttractionMaintenance> findAllByDate(Date date);

}
