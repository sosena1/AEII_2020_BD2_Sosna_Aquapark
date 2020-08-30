package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.Employee;
import pl.bd.aquapark.dao.User;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
