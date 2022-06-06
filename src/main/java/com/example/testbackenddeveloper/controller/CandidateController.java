package com.example.testbackenddeveloper.controller;

import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.models.views.CandidateDto;
import com.example.testbackenddeveloper.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/candidate")
@RestController
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/")
    public ResponseEntity<Candidate>create(@RequestBody CandidateDto candidate) {
        return new ResponseEntity<>(candidateService.save(candidate), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Candidate>>getAll() {
        return new ResponseEntity<>(candidateService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getById(@RequestParam Long id) {
        return new ResponseEntity<>(candidateService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus>deleteById(@RequestParam Long id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object>updateCandidate(@RequestBody Candidate candidate, @RequestParam Long id) {
        return new ResponseEntity<>(candidateService.update(candidate,id), HttpStatus.OK);
    }
}
