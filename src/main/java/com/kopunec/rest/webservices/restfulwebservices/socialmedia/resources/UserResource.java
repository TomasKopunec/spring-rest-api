package com.kopunec.rest.webservices.restfulwebservices.socialmedia.resources;

import com.kopunec.rest.webservices.restfulwebservices.socialmedia.entities.User;
import com.kopunec.rest.webservices.restfulwebservices.socialmedia.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<User> getUser(@PathVariable Integer id) {
        EntityModel<User> model = EntityModel.of(userService.findOne(id));
        model.add(linkTo(methodOn(UserResource.class).getAllUsers()).withRel("all-users"));
        model.add(linkTo(methodOn(UserResource.class).getUser(id)).withSelfRel());
        return model;
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
