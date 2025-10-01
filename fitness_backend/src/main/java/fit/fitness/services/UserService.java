package fit.fitness.services;

import fit.fitness.entities.User;
import fit.fitness.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService
{
        @Autowired
        private UserRepository repo;

        public Optional<User> GetById(Integer id)
        {
                return repo.findById(id);
        }

        public Optional<User> GetByPhoneNumber(String phoneNumber)
        {
                return repo.findByPhoneNumber(phoneNumber);
        }

        public User CreateUser(String name, String phone, String password) {
                User user = new User();
                user.setName(name);
                user.setPhoneNumber(phone);
                user.setPassword(password);
                return repo.save(user);
        }
}
