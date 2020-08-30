package pl.bd.aquapark.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.Role;
import pl.bd.aquapark.dao.Visit;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
