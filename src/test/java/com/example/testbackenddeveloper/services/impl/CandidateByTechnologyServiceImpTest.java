package com.example.testbackenddeveloper.services.impl;

import com.example.testbackenddeveloper.exception.CandidateByTechnologyNotFoundException;
import com.example.testbackenddeveloper.models.entities.CandidateByTechnology;
import com.example.testbackenddeveloper.models.views.CandidateByTechnologyDto;
import com.example.testbackenddeveloper.projection.CandidateByTechnologyProjection;
import com.example.testbackenddeveloper.repository.CandidateByTechnologyRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateByTechnology;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateByTechnologyDto;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateByTechnologyList;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateByTechnologyProjection;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateByTechnologyProjectionList;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateByTechnologyWithoutId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CandidateByTechnologyServiceImpTest extends AbstractMvcTestServices {

    @InjectMocks
    CandidateByTechnologyServiceImp candidateByTechnologyServiceImp;

    @Mock
    CandidateByTechnologyRepository candidateByTechnologyRepository;

    @Test
    void findByIdTest() {
        CandidateByTechnology newCandidateByTechnology = getCandidateByTechnology();
        when(candidateByTechnologyRepository.findById(1L)).thenReturn(Optional.ofNullable(getCandidateByTechnology()));
        CandidateByTechnology result = candidateByTechnologyServiceImp.findById(1L);
        verify(candidateByTechnologyRepository, atLeastOnce()).findById(1L);
        assertEquals(newCandidateByTechnology, result);
    }


    @Nested
    class FindAllCandidateByTechnologyTest {

        @Test
        void findAllCandidateByTechnologyTest() {
            List<CandidateByTechnology> list = getCandidateByTechnologyList();
            List<CandidateByTechnologyDto> listDto = new ArrayList<>();
            listDto.add(getCandidateByTechnologyDto());

            when(candidateByTechnologyRepository.findAll()).thenReturn(list);
            assertEquals(listDto, candidateByTechnologyServiceImp.findAll());
        }

        @Test
        void findAllCandidateByTechnologyTestFail() {
            assertThrows(CandidateByTechnologyNotFoundException.class, () -> candidateByTechnologyServiceImp.findAll());
        }
    }

    @Test
    void saveCandidateByTechnologyTest() {

        when(candidateByTechnologyRepository.save(getCandidateByTechnologyWithoutId())).thenReturn(getCandidateByTechnology());
        candidateByTechnologyServiceImp.save(getCandidateByTechnologyDto());

        Mockito.verify(candidateByTechnologyRepository, atLeastOnce()).save(getCandidateByTechnologyWithoutId());
    }
    
    @Test
    void findByNameTechnology() {

        String technologyName = "java";
        CandidateByTechnologyProjection newCandidateByTechnology = getCandidateByTechnologyProjection();
        List<CandidateByTechnologyProjection> prototipo = getCandidateByTechnologyProjectionList();

        when(candidateByTechnologyRepository.getByNameTechnology(technologyName)).thenReturn(getCandidateByTechnologyProjectionList());

        List<CandidateByTechnologyProjection> result = candidateByTechnologyServiceImp.getByNameTechnology(technologyName);
        verify(candidateByTechnologyRepository, atLeastOnce()).getByNameTechnology(technologyName);

        assertEquals(prototipo.get(0).getName(), result.get(0).getName());
    }
}
