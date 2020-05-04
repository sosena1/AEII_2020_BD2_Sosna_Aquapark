package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.Client;
import pl.bd.aquapark.dao.Employee;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
}
