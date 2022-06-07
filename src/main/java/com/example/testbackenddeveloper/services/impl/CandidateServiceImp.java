package com.example.testbackenddeveloper.services.impl;

import com.example.testbackenddeveloper.exception.CandidateNotExistException;
import com.example.testbackenddeveloper.exception.CandidateNotFoundException;
import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.models.views.CandidateDto;
import com.example.testbackenddeveloper.repository.CandidateRepository;
import com.example.testbackenddeveloper.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<CandidateDto> findAll() throws CandidateNotFoundException {
        List<Candidate> candidates = candidateRepository.findAll();
        List<CandidateDto> candidateDtos = new ArrayList<>();

        if (candidates.isEmpty()) {
            throw new CandidateNotFoundException("La lista de candidatos esta vacia");
        }

        candidates.forEach(candidate ->
                candidateDtos.add(CandidateDto.builder()
                        .type(candidate.getType())
                        .lastName(candidate.getLastName())
                        .name(candidate.getName())
                        .dni(candidate.getDni())
                        .birthday(candidate.getBirthday())
                        .candidateByTechnologies(candidate.getCandidateByTechnologies())
                        .build()
                ));
        return candidateDtos;
    }

    @Override
    @Transactional
    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new CandidateNotExistException("No existe un candidato con ese id"));
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public Candidate save(CandidateDto candidateDto) {

        Candidate candidate = Candidate.builder()
                .birthday(candidateDto.getBirthday())
                .dni(candidateDto.getDni())
                .name(candidateDto.getName())
                .lastName(candidateDto.getLastName())
                .type(candidateDto.getType())
                .build();
        return candidateRepository.save(candidate);
    }

    public Candidate update(Candidate candidate, Long id) {
        return candidateRepository.save(candidate);
    }
}
