package pl.bd.aquapark.endpoint.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUserName(String username);
}
