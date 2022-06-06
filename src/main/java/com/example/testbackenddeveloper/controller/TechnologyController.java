package com.example.testbackenddeveloper.controller;

import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.services.TechonologyService;
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

@RequestMapping(value = "/api/techonology")
@RestController
public class TechnologyController {

    @Autowired
    private TechonologyService techonologyService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Technology technology) {
        return new ResponseEntity<>(techonologyService.save(technology), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Technology>>getAll() {
        return new ResponseEntity<>(techonologyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getById(@RequestParam Long id) {
        return new ResponseEntity<>(techonologyService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteById(@RequestParam Long id) {
        techonologyService.deleteTechonology(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object>updateTechnology(@RequestBody Technology technology,@RequestParam Long id) {
        return new ResponseEntity<>(techonologyService.update(technology,id), HttpStatus.OK);
    }
}
