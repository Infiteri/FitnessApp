package fit.fitness.repositories;

import fit.fitness.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>
{
        Optional<Workout> findByName(String name);

        List<Workout> findAllByUserId(Integer userId);
}
