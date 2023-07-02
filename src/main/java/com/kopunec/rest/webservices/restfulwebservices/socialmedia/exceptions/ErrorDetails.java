package com.kopunec.rest.webservices.restfulwebservices.socialmedia.exceptions;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp, String message, String details) {
}
