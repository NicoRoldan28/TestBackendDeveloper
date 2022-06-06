package com.example.testbackenddeveloper.services.impl;

import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.models.views.TechnologyDto;
import com.example.testbackenddeveloper.repository.TechnologyRepository;
import com.example.testbackenddeveloper.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImp implements TechnologyService {

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
    public void deleteTechnology(Long id) {
        technologyRepository.deleteById(id);
    }

    @Override
    public Technology save(TechnologyDto technologyDto) {

        Technology technology = Technology.builder()
                .name(technologyDto.getName())
                .version(technologyDto.getVersion())
                .build();
        return technologyRepository.save(technology);
    }

    @Override
    public Technology update(TechnologyDto technologyDto, Long id) {
        Technology technology = Technology.builder()
                .name(technologyDto.getName())
                .version(technologyDto.getVersion())
                .build();
        return technologyRepository.save(technology);
    }
}