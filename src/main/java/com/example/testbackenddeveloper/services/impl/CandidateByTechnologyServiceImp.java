package com.example.testbackenddeveloper.services.impl;

import com.example.testbackenddeveloper.exception.CandidateByTechnologyNotExistException;
import com.example.testbackenddeveloper.exception.CandidateByTechnologyNotFoundException;
import com.example.testbackenddeveloper.models.entities.CandidateByTechnology;
import com.example.testbackenddeveloper.models.views.CandidateByTechnologyDto;
import com.example.testbackenddeveloper.projection.CandidateByTechnologyProjection;
import com.example.testbackenddeveloper.repository.CandidateByTechnologyRepository;
import com.example.testbackenddeveloper.services.CandidateByTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateByTechnologyServiceImp implements CandidateByTechnologyService {

    @Autowired
    private CandidateByTechnologyRepository candidateByTechnologyRepository;

    @Override
    public List<CandidateByTechnologyDto> findAll() {

        List<CandidateByTechnology> candidateByTechnologyList = candidateByTechnologyRepository.findAll();
        List<CandidateByTechnologyDto> candidateByTechnologyDtoList = new ArrayList<>();

        if (candidateByTechnologyList.isEmpty()) {
            throw new CandidateByTechnologyNotFoundException("La lista de candidato x tecnologia esta vacia");
        }

        candidateByTechnologyList.forEach(candidate ->
                candidateByTechnologyDtoList.add(CandidateByTechnologyDto.builder()
                        .candidate(candidate.getCandidate())
                        .technology(candidate.getTechnology())
                        .yearsOfExperience(candidate.getYearsOfExperience())
                        .build()
                ));
        return candidateByTechnologyDtoList;
    }

    @Override
    public CandidateByTechnology findById(Long id) {
        return candidateByTechnologyRepository.findById(id).orElseThrow(() -> new CandidateByTechnologyNotExistException("No existe una un candidato x tecnologia con ese id"));
    }

    @Override
    public CandidateByTechnology save(CandidateByTechnologyDto candidateByTechnologyDto) {
        CandidateByTechnology candidate = CandidateByTechnology.builder()
                .candidate(candidateByTechnologyDto.getCandidate())
                .technology(candidateByTechnologyDto.getTechnology())
                .yearsOfExperience(candidateByTechnologyDto.getYearsOfExperience())
                .build();
        return candidateByTechnologyRepository.save(candidate);
    }

    @Override
    public List<CandidateByTechnologyProjection> getByNameTechnology(String name) {
        return candidateByTechnologyRepository.getByNameTechnology(name);
    }

}
