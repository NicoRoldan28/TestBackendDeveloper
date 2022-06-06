package com.example.testbackenddeveloper.controller;

import com.example.testbackenddeveloper.models.entities.Technology;
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

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Technology technology) {
    }

    @GetMapping("/")
    public ResponseEntity<List<Object>>getAll() {
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getById(@RequestParam Long id) {
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteById(@RequestParam Long id) {
    }

    @PatchMapping("/{id")
    public ResponseEntity<Object>updateTechnology(@RequestParam Long id) {
    }
}
