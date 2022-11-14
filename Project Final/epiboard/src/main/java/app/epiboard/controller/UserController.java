package app.epiboard.controller;

import app.epiboard.model.User;
import app.epiboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return repo.findAll();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return repo.save(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> findUser(@PathVariable Long id) {
        return repo.findById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
    }


}
