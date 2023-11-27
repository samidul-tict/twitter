package com.demo.twitter.exception;

public class DeserializationException extends RuntimeException {

    public DeserializationException(String name) {

        super("Could not find employee " + name);
    }
}