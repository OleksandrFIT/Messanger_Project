package messanger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import messanger.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUserName(String userName);

    Optional<User> findByPhoneNumber(String phoneNumber);
}
