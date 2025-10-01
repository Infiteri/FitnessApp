package fit.fitness.controller;

import fit.fitness.entities.User;
import fit.fitness.repositories.UserRepository;
import fit.fitness.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController
{
        @Autowired
        private UserService service;

        // GET
        @GetMapping("/id")
        public ResponseEntity<User> GetUserById(@RequestParam int id)
        {
                var user = service.GetById(id);
                if (user.isEmpty())
                        return ResponseEntity.notFound().build();
                else
                        return ResponseEntity.ok(user.get());
        }

        @GetMapping("/phoneNumber")
        public ResponseEntity<User> GetUserById(@RequestParam String phoneNumber)
        {
                var user = service.GetByPhoneNumber(phoneNumber);
                if (user.isEmpty())
                        return ResponseEntity.notFound().build();
                else
                        return ResponseEntity.ok(user.get());
        }

        // POST
        @PostMapping
        public ResponseEntity<User> CreateUser(@RequestBody User user) {
                var usr =  service.CreateUser(user.getName(), user.getPhoneNumber(), user.getPassword());
                return ResponseEntity.ok(usr);
        }

        @PostMapping("/login")
        public ResponseEntity<User> LoginUser(@RequestParam String phoneNumber, @RequestParam String password) {
                var user = service.GetByPhoneNumber(phoneNumber);
                if(user.isEmpty())
                        return ResponseEntity.notFound().build();

                if(!password.equals(user.get().getPassword()))
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

                return ResponseEntity.status(HttpStatus.OK).build();
        }


        // PUT

        // DELETE
}
