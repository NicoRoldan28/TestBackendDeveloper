package com.example.testbackenddeveloper.services;

import com.example.testbackenddeveloper.models.entities.CandidateByTechnology;
import com.example.testbackenddeveloper.models.views.CandidateByTechnologyDto;
import com.example.testbackenddeveloper.projection.CandidateByTechnologyProjection;

import java.util.List;

public interface CandidateByTechnologyService {

    List<CandidateByTechnologyDto> findAll();

    CandidateByTechnology findById(Long id);

    CandidateByTechnology save(CandidateByTechnologyDto candidateByTechnologyDto);

    List<CandidateByTechnologyProjection> getByNameTechnology(String name);

}
