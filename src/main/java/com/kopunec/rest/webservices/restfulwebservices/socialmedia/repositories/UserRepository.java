package com.kopunec.rest.webservices.restfulwebservices.socialmedia.repositories;

import com.kopunec.rest.webservices.restfulwebservices.socialmedia.entities.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(@NotNull Integer id);

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteById(@NotNull Integer id);
}
