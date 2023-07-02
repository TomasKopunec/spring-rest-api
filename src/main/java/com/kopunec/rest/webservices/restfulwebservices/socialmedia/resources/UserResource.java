package com.kopunec.rest.webservices.restfulwebservices.socialmedia.resources;

import com.kopunec.rest.webservices.restfulwebservices.socialmedia.entities.User;
import com.kopunec.rest.webservices.restfulwebservices.socialmedia.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserResource {

    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.findOne(id);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
