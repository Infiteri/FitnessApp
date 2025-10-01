package fit.fitness.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="workouts")
public class Workout
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name="workout_datetime")
        private LocalDateTime workoutDateTime;

        @Column(name="name")
        private String name;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        public Integer getId()
        {
                return id;
        }

        public LocalDateTime getWorkoutDateTime()
        {
                return workoutDateTime;
        }

        public void setWorkoutDateTime(LocalDateTime workoutDate)
        {
                this.workoutDateTime = workoutDate;
        }

        public String getName()
        {
                return name;
        }

        public void setName(String name)
        {
                this.name = name;
        }

        public User getUser()
        {
                return user;
        }

        public void setUser(User user)
        {
                this.user = user;
        }
}
