package com.kopunec.rest.webservices.restfulwebservices.socialmedia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
    public static EntityNotFoundException create(Class<?> entityType, Integer id) {
        return new EntityNotFoundException(entityType.getSimpleName() + " with id " + id + " not found");
    }
}
