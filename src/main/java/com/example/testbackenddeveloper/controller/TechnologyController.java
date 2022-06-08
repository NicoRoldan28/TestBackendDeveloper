package com.example.testbackenddeveloper.controller;

import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.models.views.TechnologyDto;
import com.example.testbackenddeveloper.services.TechnologyService;
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

@RequestMapping(value = "/api/technology")
@RestController
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @PostMapping("/")
    public ResponseEntity<URI> create(@Valid @RequestBody TechnologyDto technologyDto) {

        Technology newTechnology = technologyService.save(technologyDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTechnology.getTechnologyId())
                .toUri();
        return new ResponseEntity<>(location, (HttpStatus.CREATED));
    }

    @GetMapping("/")
    public ResponseEntity<List<TechnologyDto>> getAll() {
        return new ResponseEntity<>(technologyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technology> getById(@PathVariable Long id) {
        return new ResponseEntity<>(technologyService.findById(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        technologyService.deleteTechnology(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateTechnology(@Valid @RequestBody TechnologyDto technologyDto, @PathVariable Long id) {
        technologyService.update(technologyDto, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
