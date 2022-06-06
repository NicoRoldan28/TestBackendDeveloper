package com.example.testbackenddeveloper.controller;

import com.example.testbackenddeveloper.models.entities.CandidateByTechnology;
import com.example.testbackenddeveloper.models.views.CandidateByTechnologyDto;
import com.example.testbackenddeveloper.projection.CandidateByTechnologyProjection;
import com.example.testbackenddeveloper.services.CandidateByTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "api/candidatoByTechnology")
@RestController
public class CandidateByTechnologyController {

    @Autowired
    private CandidateByTechnologyService candidateByTechnologyService;

    @PostMapping("/")
    public ResponseEntity<CandidateByTechnology> create(@RequestBody CandidateByTechnologyDto candidateByTechnologyDto) {
        return new ResponseEntity<>(candidateByTechnologyService.save(candidateByTechnologyDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CandidateByTechnology>> getAll(){
        return new ResponseEntity<>(candidateByTechnologyService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateByTechnology> getById(@RequestParam Long id){
        return new ResponseEntity<>(candidateByTechnologyService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/nameTechnology/{name}")
    public ResponseEntity<List<CandidateByTechnologyProjection>> getByNameTechnology(@PathVariable String name) {
        return new ResponseEntity<>(candidateByTechnologyService.getByNameTechnology(name),HttpStatus.OK);
    }

}
