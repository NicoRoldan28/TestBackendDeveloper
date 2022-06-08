package com.example.testbackenddeveloper.controller;

import com.example.testbackenddeveloper.exception.CandidateNotFoundException;
import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.models.views.CandidateDto;
import com.example.testbackenddeveloper.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping(value = "/api/candidate")
@RestController
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/")
    public ResponseEntity<URI> create(@Valid @RequestBody CandidateDto candidateDto) {
        Candidate newCandidate = candidateService.save(candidateDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCandidate.getCandidateId())
                .toUri();
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CandidateDto>> getAll() throws CandidateNotFoundException {
        return new ResponseEntity<>(candidateService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getById(@PathVariable Long id) {
        return new ResponseEntity<>(candidateService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCandidate(@Valid @RequestBody CandidateDto candidateDto, @PathVariable Long id) {
        return new ResponseEntity<>(candidateService.update(candidateDto, id), HttpStatus.OK);
    }
}
