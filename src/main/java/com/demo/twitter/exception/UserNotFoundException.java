package com.demo.twitter.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String name) {
        super("Could not find employee " + name);
    }
}