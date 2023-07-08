package com.kopunec.rest.webservices.restfulwebservices.socialmedia.repositories;

import com.kopunec.rest.webservices.restfulwebservices.socialmedia.entities.UserDetails;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    Optional<UserDetails> findById(@NotNull Integer id);

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteById(@NotNull Integer id);
}
