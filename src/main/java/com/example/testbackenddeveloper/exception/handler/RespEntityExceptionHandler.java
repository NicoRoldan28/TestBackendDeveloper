package com.example.testbackenddeveloper.exception.handler;

import com.example.testbackenddeveloper.exception.CandidateByTechnologyNotExistException;
import com.example.testbackenddeveloper.exception.CandidateByTechnologyNotFoundException;
import com.example.testbackenddeveloper.exception.CandidateNotExistException;
import com.example.testbackenddeveloper.exception.CandidateNotFoundException;
import com.example.testbackenddeveloper.exception.TechnologyNotExistException;
import com.example.testbackenddeveloper.exception.TechnologyNotFoundException;
import com.example.testbackenddeveloper.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class RespEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ResponseMessage> entityNotFoundException(EntityNotFoundException entityNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body((ResponseMessage.builder()
                        .message(entityNotFoundException.getMessage()).build()));
    }

    @ExceptionHandler(CandidateNotExistException.class)
    public ResponseEntity<ResponseMessage> candidateNotExistException(CandidateNotExistException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }

    @ExceptionHandler(CandidateNotFoundException.class)
    ResponseEntity<ResponseMessage> candidateNotFoundException(EntityNotFoundException entityNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body((ResponseMessage.builder()
                        .message(entityNotFoundException.getMessage()).build()));
    }

    @ExceptionHandler(TechnologyNotExistException.class)
    public ResponseEntity<ResponseMessage> technologyNotExistException(TechnologyNotExistException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }

    @ExceptionHandler(TechnologyNotFoundException.class)
    ResponseEntity<ResponseMessage> technologyNotFoundException(EntityNotFoundException entityNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body((ResponseMessage.builder()
                        .message(entityNotFoundException.getMessage()).build()));
    }

    @ExceptionHandler(CandidateByTechnologyNotFoundException.class)
    ResponseEntity<ResponseMessage> candidateByTechnologyNotFoundException(EntityNotFoundException entityNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body((ResponseMessage.builder()
                        .message(entityNotFoundException.getMessage()).build()));
    }

    @ExceptionHandler(CandidateByTechnologyNotExistException.class)
    public ResponseEntity<ResponseMessage> candidateByTechnologyNotExistException(CandidateByTechnologyNotExistException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }
}
