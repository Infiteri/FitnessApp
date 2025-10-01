package fit.fitness.services;

import fit.fitness.entities.Exercise;
import fit.fitness.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseService
{
        @Autowired
        private ExerciseRepository repo;

        public Optional<Exercise> GetExerciseByName(String name)
        {
                return repo.findExerciseByName(name);
        }
}

