package fit.fitness.controller;

import fit.fitness.entities.Workout;
import fit.fitness.entities.WorkoutExercise;
import fit.fitness.services.ExerciseService;
import fit.fitness.services.WorkoutExerciseService;
import fit.fitness.services.WorkoutService;
import org.hibernate.jdbc.Work;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.ListDataEvent;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/workout")
@CrossOrigin(origins = "http://localhost:5173")
public class WorkoutController
{
        private static final Logger LOG = Logger.getLogger(WorkoutController.class.getName());

        @Autowired
        private WorkoutService service;

        @Autowired
        private WorkoutExerciseService workoutExerciseService;

        // GET
        @GetMapping
        public ResponseEntity<Workout> GetWorkoutById(@RequestParam int id)
        {
                var workout = service.GetById(id);
                if (workout.isEmpty()) return ResponseEntity.notFound().build();
                else return ResponseEntity.ok(workout.get());
        }

        @GetMapping("/all")
        public ResponseEntity<List<Workout>> GetAllWorkoutsByUserId(@RequestParam int userId)
        {
                return ResponseEntity.ok(service.GetAllByUserId(userId));
        }

        @GetMapping("/exercises")
        public ResponseEntity<List<WorkoutExercise>> GetWorkoutExercisesByWorkoutId(@RequestParam int workoutId)
        {
                var list = workoutExerciseService.GetWorkoutExercisesWithWorkoutId(workoutId);
                return ResponseEntity.ok(list);
        }

        // POST
        @PostMapping
        public ResponseEntity<Workout> CreateWorkout(@RequestBody Workout workout)
        {
                LocalDateTime time = workout.getWorkoutDateTime() != null ? workout.getWorkoutDateTime() : LocalDateTime.now();
                var res = service.CreateWorkout(workout.getUser().getId(), workout.getName(), time);
                if (res == null) return ResponseEntity.badRequest().build();
                else return ResponseEntity.ok(res);
        }

        @PostMapping("/exercises")
        public ResponseEntity<WorkoutExercise> CreateWorkoutExerciseByWorkoutId(@RequestBody WorkoutExercise workoutExercise)
        {
                var ex = workoutExerciseService.CreateWorkoutExercise(workoutExercise.getWorkout().getId(),
                        workoutExercise.getExercise().getName(),
                        workoutExercise.getIntensity(),
                        workoutExercise.getDescription());
                if (ex == null) return ResponseEntity.badRequest().build();
                return ResponseEntity.ok(ex);
        }

        // PUT
        @PutMapping
        public ResponseEntity<Workout> UpdateWorkout(@RequestBody Workout workout) {
                var result = service.UpdateWorkout(workout.getId(), workout.getName(), workout.getWorkoutDateTime());
                if(result == null) return ResponseEntity.badRequest().build();
                else return ResponseEntity.ok(result);
        }

        // DELETE
        @DeleteMapping
        public ResponseEntity<Workout> DeleteWorkoutById(@RequestParam int id)
        {
                service.DeleteWorkoutById(id);
                return ResponseEntity.ok().build();
        }

        @DeleteMapping("/exercises")
        public ResponseEntity<WorkoutExercise> DeleteWorkoutExerciseByWorkoutId(@RequestParam int workoutId, @RequestParam int exerciseId)
        {
                workoutExerciseService.DeleteWorkoutExercise(workoutId, exerciseId);
                return ResponseEntity.ok().build();
        }
}
