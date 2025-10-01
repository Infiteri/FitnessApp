package org.example.models;

import java.time.LocalDateTime;

public class Workout
{
        private int id;
        private LocalDateTime workoutDateTime;
        private String name;
        private User user;

        public int GetId()
        {
                return id;
        }

        public void SetId(int id)
        {
                this.id = id;
        }

        public LocalDateTime GetWorkoutDateTime()
        {
                return workoutDateTime;
        }

        public void SetWorkoutDateTime(LocalDateTime workoutDateTime)
        {
                this.workoutDateTime = workoutDateTime;
        }

        public String GetName()
        {
                return name;
        }

        public void SetName(String name)
        {
                this.name = name;
        }

        public User GetUser()
        {
                return user;
        }

        public void SetUser(User user)
        {
                this.user = user;
        }
}
