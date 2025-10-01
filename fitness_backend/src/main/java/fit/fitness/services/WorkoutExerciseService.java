package fit.fitness.services;

import fit.fitness.entities.WorkoutExercise;
import fit.fitness.repositories.ExerciseRepository;
import fit.fitness.repositories.WorkoutExerciseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutExerciseService
{
        @Autowired
        private WorkoutExerciseRepository repo;

        @Autowired
        private ExerciseService exerciseService;

        @Autowired
        private WorkoutService workoutService;

        public List<WorkoutExercise> GetWorkoutExercisesWithWorkoutId(int workoutId)
        {
                return repo.findAllByWorkoutId(workoutId);
        }

        public WorkoutExercise CreateWorkoutExercise(int workoutId, String exerciseName, int intensity, String description)
        {
                var workout = workoutService.GetById(workoutId);
                if (workout.isEmpty()) return null;

                var exercise = exerciseService.GetExerciseByName(exerciseName);
                if (exercise.isEmpty()) return null;

                WorkoutExercise ex = new WorkoutExercise();
                ex.setWorkout(workout.get());
                ex.setExercise(exercise.get());
                ex.setIntensity(intensity);
                ex.setDescription(description);
                return repo.save(ex);
        }

        @Transactional
        public void DeleteWorkoutExercise(int workoutId, int exerciseId)
        {
                repo.deleteByWorkout_IdAndId(workoutId, exerciseId);
        }
}
