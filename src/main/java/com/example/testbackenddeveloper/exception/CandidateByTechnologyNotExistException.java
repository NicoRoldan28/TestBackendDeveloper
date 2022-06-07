package com.example.testbackenddeveloper.exception;

public class CandidateByTechnologyNotExistException extends RuntimeException {
    public CandidateByTechnologyNotExistException(String message) {
        super(message);
    }
}
