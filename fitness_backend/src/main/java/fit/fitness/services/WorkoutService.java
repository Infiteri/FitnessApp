package fit.fitness.services;

import fit.fitness.entities.Workout;
import fit.fitness.repositories.UserRepository;
import fit.fitness.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class WorkoutService
{
        private static final Logger LOG = Logger.getLogger(WorkoutService.class.getName());

        @Autowired
        private WorkoutRepository repo;

        @Autowired
        private UserRepository userRepo;

        // GET

        public Optional<Workout> GetById(int id)
        {
                return repo.findById(id);
        }

        public List<Workout> GetAllByUserId(int userId)
        {
                return repo.findAllByUserId(userId);
        }


        public Optional<Workout> GetByName(String name)
        {
                return repo.findByName(name);
        }

        // POST
        public Workout CreateWorkout(int userId, String name, LocalDateTime time)
        {
                var user = userRepo.findById(userId);
                if (user.isEmpty()) return null;

                Workout workout = new Workout();
                workout.setName(name);
                workout.setWorkoutDateTime(time);
                workout.setUser(user.get());
                return repo.save(workout);
        }

        // PUT

        // DELETE
        public void DeleteWorkoutById(int id)
        {
                repo.deleteById(id);
        }
}
