package pl.bd.aquapark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
