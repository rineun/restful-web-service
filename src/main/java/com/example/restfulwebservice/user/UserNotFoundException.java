package com.example.restfulwebservice.user;
// HTTP Status code
// 2XX ->ok
// 4XX -> Client
// 5XX -> Server

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
