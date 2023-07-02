package com.kopunec.rest.webservices.restfulwebservices.socialmedia.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception e, WebRequest request) {
        return new ResponseEntity<>(getErrorDetails(e, request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleNotFoundExceptions(Exception e, WebRequest request) {
        return new ResponseEntity<>(getErrorDetails(e, request), HttpStatus.NOT_FOUND);
    }

    private ErrorDetails getErrorDetails(Exception e, WebRequest request) {
        return new ErrorDetails(LocalDateTime.now(), e.getMessage(), request.getDescription(false));
    }
}
