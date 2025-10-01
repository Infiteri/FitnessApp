package fit.fitness.entities;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name="name")
        private String name;

        @Column(name="phone_number")
        private String phoneNumber;

        @Column(name="password")
        private String password;


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

        public String getPhoneNumber()
        {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber)
        {
                this.phoneNumber = phoneNumber;
        }

        public String getPassword()
        {
                return password;
        }

        public void setPassword(String password)
        {
                this.password = password;
        }
}
