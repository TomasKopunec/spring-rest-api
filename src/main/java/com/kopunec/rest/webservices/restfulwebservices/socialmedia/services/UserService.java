package com.kopunec.rest.webservices.restfulwebservices.socialmedia.services;

import com.kopunec.rest.webservices.restfulwebservices.socialmedia.entities.User;
import com.kopunec.rest.webservices.restfulwebservices.socialmedia.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private List<User> users = new ArrayList<>(List.of(
            new User(1, "Adam", LocalDate.of(1992, 9, 29)),
            new User(2, "Eve", LocalDate.of(2000, 2, 4)),
            new User(3, "Jack", LocalDate.of(1998, 6, 15))
    ));


    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        return users.stream()
                .filter(u -> Objects.equals(u.getId(), user.getId()))
                .findFirst()
                .orElseGet(() -> {
                    user.setId(users.size() + 1);
                    users.add(user);
                    return user;
                });
    }

    public User findOne(Integer id) {
        return users.stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst()
                .orElseThrow(() -> EntityNotFoundException.create(User.class, id));
    }

    public void deleteById(Integer id) {
        if(!users.removeIf(user -> Objects.equals(user.getId(), id))) {
            throw EntityNotFoundException.create(User.class, id);
        }
    }
}
