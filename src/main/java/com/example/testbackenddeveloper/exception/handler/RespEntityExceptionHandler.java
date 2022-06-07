package com.example.testbackenddeveloper.exception.handler;

import com.example.testbackenddeveloper.exception.CandidateByTechnologyNotExistException;
import com.example.testbackenddeveloper.exception.CandidateByTechnologyNotFoundException;
import com.example.testbackenddeveloper.exception.CandidateNotExistException;
import com.example.testbackenddeveloper.exception.CandidateNotFoundException;
import com.example.testbackenddeveloper.exception.TechnologyNotExistException;
import com.example.testbackenddeveloper.exception.TechnologyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RespEntityExceptionHandler {


    @ExceptionHandler(CandidateNotExistException.class)
    ResponseEntity<?> CandidateNotExistException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(CandidateNotFoundException.class)
    ResponseEntity<?> candidateNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
    }


    @ExceptionHandler(TechnologyNotExistException.class)
    public ResponseEntity<?> technologyNotExistException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(value = {TechnologyNotFoundException.class})
    ResponseEntity<?> technologyNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
    }


    @ExceptionHandler(CandidateByTechnologyNotFoundException.class)
    ResponseEntity<?> candidateByTechnologyNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
    }

    @ExceptionHandler(CandidateByTechnologyNotExistException.class)
    ResponseEntity<?> CandidateByTechnologyNotExistException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
