package com.example.testbackenddeveloper.services;

import com.example.testbackenddeveloper.models.entities.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> findAll();
    Candidate findById(Long id);
    void deleteCandidate(Long id);
    Candidate save(Candidate candidate);
    Candidate update(Candidate candidate, Long id);
}
