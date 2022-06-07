package com.example.testbackenddeveloper.services;

import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.models.views.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    List<TechnologyDto> findAll();

    Technology findById(Long id);

    void deleteTechnology(Long id);

    Technology save(TechnologyDto technology);

    Technology update(TechnologyDto technologyDto, Long id);
}
