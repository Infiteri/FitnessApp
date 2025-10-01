package fit.fitness.entities;

import jakarta.persistence.*;

@Entity
@Table(name="workout_exercises")
public class WorkoutExercise
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @ManyToOne
        @JoinColumn(name="workout_id")
        private Workout workout;

        @ManyToOne
        @JoinColumn(name="exercise_id")
        private Exercise exercise;

        @Column(name="intensity")
        private Integer intensity;

        @Column(name="description")
        private String description;

        public Integer getId()
        {
                return id;
        }

        public Workout getWorkout()
        {
                return workout;
        }

        public void setWorkout(Workout workout)
        {
                this.workout = workout;
        }

        public Exercise getExercise()
        {
                return exercise;
        }

        public void setExercise(Exercise exercise)
        {
                this.exercise = exercise;
        }

        public Integer getIntensity()
        {
                return intensity;
        }

        public void setIntensity(Integer intensity)
        {
                this.intensity = intensity;
        }

        public String getDescription()
        {
                return description;
        }

        public void setDescription(String description)
        {
                this.description = description;
        }
}
