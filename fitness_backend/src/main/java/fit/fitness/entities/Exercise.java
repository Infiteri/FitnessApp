package fit.fitness.entities;

import jakarta.persistence.*;

@Entity
@Table(name="exercises")
public class Exercise
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name="name")
        private String name;

        @Column(name="muscles")
        private String muscles;

        public Integer getId()
        {
                return id;
        }

        public String getName()
        {
                return name;
        }

        public void setName(String name)
        {
                this.name = name;
        }

        public String getMuscles()
        {
                return muscles;
        }

        public void setMuscles(String muscles)
        {
                this.muscles = muscles;
        }
}
