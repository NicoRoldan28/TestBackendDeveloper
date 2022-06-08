package com.example.testbackenddeveloper.services.impl;

import com.example.testbackenddeveloper.exception.CandidateNotFoundException;
import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.models.views.CandidateDto;
import com.example.testbackenddeveloper.repository.CandidateRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidate;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateDto;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateList;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateWithoutId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CandidateServiceImpTest extends AbstractMvcTestServices {

    @InjectMocks
    CandidateServiceImp candidateServiceImp;

    @Mock
    CandidateRepository candidateRepository;

    @Test
    void findByIdTest() {
        Candidate newCandidate = getCandidate();
        when(candidateRepository.findById(1L)).thenReturn(Optional.ofNullable(getCandidate()));
        Candidate candidateResultado = candidateServiceImp.findById(1L);
        verify(candidateRepository, atLeastOnce()).findById(1L);
        assertEquals(newCandidate, candidateResultado);
    }

    @Nested
    class FindAllCandidateTest {

        @Test
        void findAllCandidateTest() {
            List<Candidate> candidateList = getCandidateList();
            List<CandidateDto> candidateDtoList = new ArrayList<>();
            candidateDtoList.add(getCandidateDto());

            when(candidateRepository.findAll()).thenReturn(candidateList);
            assertEquals(candidateDtoList, candidateServiceImp.findAll());
        }

        @Test
        void findAllCandidateTestFail() {
            assertThrows(CandidateNotFoundException.class, () -> candidateServiceImp.findAll());
        }
    }

    @Test
    void deleteCandidateTest() {
        candidateServiceImp.deleteCandidate(getCandidate().getCandidateId());
        Mockito.verify(candidateRepository, atLeastOnce()).deleteById(getCandidate().getCandidateId());
    }

    @Test
    void saveCandidateTest() {

        when(candidateRepository.save(getCandidateWithoutId())).thenReturn(getCandidate());
        candidateServiceImp.save(getCandidateDto());

        Mockito.verify(candidateRepository, atLeastOnce()).save(getCandidateWithoutId());
    }

    @Nested
    class UpdateCandidateTest {
        @Test
        void updateCandidateTest() {
            when(candidateRepository.findById(1L)).thenReturn(Optional.ofNullable(getCandidate()));

            candidateServiceImp.update(getCandidateDto(), 1L);

            verify(candidateRepository, atLeastOnce()).save(getCandidate());
        }

        @Test
        void updateCandidateTestFail() {
            assertThrows(CandidateNotFoundException.class, () -> candidateServiceImp.update(getCandidateDto(), 2L));
        }
    }

}
