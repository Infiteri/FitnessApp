package fit.fitness.repositories;

import fit.fitness.entities.WorkoutExercise;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkoutExerciseRepository extends CrudRepository<WorkoutExercise, Integer>
{
        List<WorkoutExercise> findAllByWorkoutId(Integer workoutId);

        void deleteByWorkout_IdAndId(Integer workoutId, Integer id);
}
