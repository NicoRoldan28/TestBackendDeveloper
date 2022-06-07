package com.example.testbackenddeveloper.services.impl;

import com.example.testbackenddeveloper.exception.TechnologyNotExistException;
import com.example.testbackenddeveloper.exception.TechnologyNotFoundException;
import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.models.views.TechnologyDto;
import com.example.testbackenddeveloper.repository.TechnologyRepository;
import com.example.testbackenddeveloper.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyServiceImp implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public List<TechnologyDto> findAll() throws TechnologyNotExistException {
        List<Technology> technologies = technologyRepository.findAll();
        List<TechnologyDto> technologyDtos = new ArrayList<>();
        if (technologies.isEmpty()) {
            throw new TechnologyNotFoundException("La lista de tecnologias esta vacia");
        } else {
            technologies.forEach(technology ->
                    technologyDtos.add(TechnologyDto.builder()
                            .version(technology.getVersion())
                            .name(technology.getName())
                            .candidateByTechnologies(technology.getCandidateByTechnologies())
                            .build()
                    ));
            return technologyDtos;
        }
    }

    @Override
    public Technology findById(Long id) {
        return technologyRepository.findById(id).orElseThrow(() -> new TechnologyNotExistException("No existe una tecnologia con ese id"));
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
