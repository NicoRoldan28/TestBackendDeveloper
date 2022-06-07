package com.example.testbackenddeveloper.exception;

public class CandidateByTechnologyNotFoundException extends RuntimeException {
    public CandidateByTechnologyNotFoundException(String message) {
        super(message);
    }
}
