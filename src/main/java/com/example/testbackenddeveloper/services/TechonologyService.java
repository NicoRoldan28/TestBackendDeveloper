package com.example.testbackenddeveloper.services;

import com.example.testbackenddeveloper.models.entities.Technology;

import java.util.List;

public interface TechonologyService {

    List<Technology> findAll();
    Technology findById(Long id);
    void deleteTechonology(Long id);
    Technology save(Technology technology);
    Technology update(Technology technology, Long id);
}
