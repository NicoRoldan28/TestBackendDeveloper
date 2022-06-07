package com.example.testbackenddeveloper.exception;

public class CandidateNotExistException extends RuntimeException {
    public CandidateNotExistException(String message) {
        super(message);
    }
}
