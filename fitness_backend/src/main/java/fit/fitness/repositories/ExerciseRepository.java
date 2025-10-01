package fit.fitness.repositories;

import fit.fitness.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer>
{
        Optional<Exercise> findExerciseByName(String name);
}
