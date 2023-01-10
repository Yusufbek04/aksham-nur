package uz.pdp.akshamnurserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.akshamnurserver.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByPhoneNumber(String username);
}
