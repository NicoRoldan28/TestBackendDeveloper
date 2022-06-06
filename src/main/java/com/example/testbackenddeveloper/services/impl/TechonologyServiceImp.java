package com.example.testbackenddeveloper.services.impl;

import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.repository.TechnologyRepository;
import com.example.testbackenddeveloper.services.TechonologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechonologyServiceImp implements TechonologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public List<Technology> findAll() {
        return technologyRepository.findAll();
    }

    @Override
    public Technology findById(Long id) {
        return technologyRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteTechonology(Long id) {
        technologyRepository.deleteById(id);
    }

    @Override
    public Technology save(Technology technology) {
        return technologyRepository.save(technology);
    }

    @Override
    public Technology update(Technology technology, Long id) {
        return technologyRepository.save(technology);
    }
}
