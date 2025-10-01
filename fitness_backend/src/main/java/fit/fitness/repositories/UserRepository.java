package fit.fitness.repositories;

import fit.fitness.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{
        Optional<User> findByPhoneNumber(String phoneNumber);
}
