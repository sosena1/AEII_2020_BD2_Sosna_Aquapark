package pl.bd.aquapark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bd.aquapark.dao.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserNameAndPassword(String username, String password);

    List<User> findUserByUserName(String username);

    List<User> findUserByPesel(String pesel);
}
