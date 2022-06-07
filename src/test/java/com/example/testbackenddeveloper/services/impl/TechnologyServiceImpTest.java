package com.example.testbackenddeveloper.services.impl;

import com.example.testbackenddeveloper.exception.TechnologyNotFoundException;
import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.models.views.TechnologyDto;
import com.example.testbackenddeveloper.repository.TechnologyRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getTechnology;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getTechnologyDto;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getTechnologyList;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getTechnologyWithoutId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TechnologyServiceImpTest extends AbstractMvcTestServices {

    @InjectMocks
    TechnologyServiceImp technologyServiceImp;

    @Mock
    TechnologyRepository technologyRepository;


    @Test
    void findByIdTest() {
        Technology newTechnology = getTechnology();
        when(technologyRepository.findById(1L)).thenReturn(Optional.ofNullable(getTechnology()));
        Technology technology = technologyServiceImp.findById(1L);
        verify(technologyRepository, atLeastOnce()).findById(1L);
        assertEquals(newTechnology, technology);
    }

    @Nested
    class FindAllCandidateTest {

        @Test
        void findAllCandidateTest() {
            List<Technology> technologyList = getTechnologyList();
            List<TechnologyDto> technologyDtoList = new ArrayList<>();
            technologyDtoList.add(getTechnologyDto());

            when(technologyRepository.findAll()).thenReturn(technologyList);
            assertEquals(technologyDtoList, technologyServiceImp.findAll());
        }

        @Test
        void findAllCandidateTestFail() {
            assertThrows(TechnologyNotFoundException.class, () -> technologyServiceImp.findAll());
        }
    }

    @Test
    void deleteCandidateTest() {
        technologyServiceImp.deleteTechnology(getTechnology().getTechnologyId());
        Mockito.verify(technologyRepository, atLeastOnce()).deleteById(getTechnology().getTechnologyId());
    }

    @Test
    void saveCandidateTest() {

        when(technologyRepository.save(getTechnologyWithoutId())).thenReturn(getTechnology());
        technologyServiceImp.save(getTechnologyDto());

        Mockito.verify(technologyRepository, atLeastOnce()).save(getTechnologyWithoutId());
    }

}
