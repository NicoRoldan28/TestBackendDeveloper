package com.example.testbackenddeveloper.services;

import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.models.views.CandidateDto;

import java.util.List;

public interface CandidateService {

    List<CandidateDto> findAll();

    Candidate findById(Long id);

    void deleteCandidate(Long id);

    Candidate save(CandidateDto candidate);

    Candidate update(CandidateDto candidateDto, Long id);
}
