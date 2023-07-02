package com.kopunec.rest.webservices.restfulwebservices.helloworld;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class HelloWorldBean {
    String message;
}
