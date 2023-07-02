package com.kopunec.rest.webservices.restfulwebservices.socialmedia.resources;

import com.kopunec.rest.webservices.restfulwebservices.socialmedia.entities.Post;
import com.kopunec.rest.webservices.restfulwebservices.socialmedia.entities.User;
import com.kopunec.rest.webservices.restfulwebservices.socialmedia.services.PostRepository;
import com.kopunec.rest.webservices.restfulwebservices.socialmedia.services.UserRepository;
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

    UserRepository userRepository;

    PostRepository postRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable Integer id) {
        EntityModel<User> model = EntityModel.of(userRepository.findById(id).get());
        model.add(linkTo(methodOn(UserResource.class).getAllUsers()).withRel("all-users"));
        model.add(linkTo(methodOn(UserResource.class).getUser(id)).withSelfRel());
        return model;
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getAllPosts(@PathVariable Integer id) {
        return userRepository.findById(id).get().getPosts();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(code = HttpStatus.CREATED)
    public List<Post> getAllPosts(@PathVariable Integer id, @Valid @RequestBody Post post) {
        User user = userRepository.findById(id).get();
        post.setUser(user);
        postRepository.save(post);
        return user.getPosts();
    }
}
