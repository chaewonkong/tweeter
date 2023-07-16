package cc.leon.tweeter.repository;

import cc.leon.tweeter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
