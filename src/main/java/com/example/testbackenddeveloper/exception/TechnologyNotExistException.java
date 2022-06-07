package com.example.testbackenddeveloper.exception;

public class TechnologyNotExistException extends RuntimeException {
    public TechnologyNotExistException(String message) {
        super(message);
    }
}
