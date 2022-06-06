package com.example.testbackenddeveloper.services.impl;

import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.repository.CandidateRepository;
import com.example.testbackenddeveloper.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate update(Candidate candidate,Long id){
        return candidateRepository.save(candidate);
    }
}
