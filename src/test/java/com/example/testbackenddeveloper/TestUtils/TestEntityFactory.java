package com.example.testbackenddeveloper.TestUtils;

import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.models.entities.CandidateByTechnology;
import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.models.enums.Type;
import com.example.testbackenddeveloper.models.views.CandidateByTechnologyDto;
import com.example.testbackenddeveloper.models.views.CandidateDto;
import com.example.testbackenddeveloper.models.views.TechnologyDto;

import java.util.ArrayList;
import java.util.List;

public class TestEntityFactory {

    public static TechnologyDto getTechnologyDto() {
        return TechnologyDto.builder()
                .name("java")
                .version("11.0")
                .candidateByTechnologies(null)
                .build();
    }

    public static Technology getTechnology() {
        return Technology.builder()
                .technologyId(1L)
                .name("java")
                .version("11.0")
                .candidateByTechnologies(null)
                .build();
    }

    public static Technology getTechnologyWithoutId() {
        return Technology.builder()
                .name("java")
                .version("11.0")
                .candidateByTechnologies(null)
                .build();
    }

    public static CandidateByTechnology getCandidateByTechnology() {
        return CandidateByTechnology.builder()
                .id(1L)
                .technology(getTechnology())
                .candidate(getCandidate())
                .yearsOfExperience(1l)
                .build();
    }

    public static CandidateByTechnologyDto getCandidateByTechnologyDto() {
        return CandidateByTechnologyDto.builder()
                .technology(getTechnology())
                .candidate(getCandidate())
                .yearsOfExperience(1l)
                .build();
    }

    public static CandidateDto getCandidateDto() {
        return CandidateDto.builder()
                .dni("12313")
                .name("nicolas")
                .lastName("roldan")
                .type(Type.DNI)
                .candidateByTechnologies(null)
                .build();
    }

    public static Candidate getCandidate() {
        return Candidate.builder()
                .candidateId(1L)
                .dni("12313")
                .name("nicolas")
                .lastName("roldan")
                .type(Type.DNI)
                .candidateByTechnologies(null)
                .build();
    }

    public static Candidate getCandidateWithoutId() {
        return Candidate.builder()
                .dni("12313")
                .name("nicolas")
                .lastName("roldan")
                .type(Type.DNI)
                .candidateByTechnologies(null)
                .build();
    }

    public static List<Candidate> getCandidateList() {
        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(getCandidate());
        return candidateList;
    }

    public static List<Technology> getTechnologyList() {
        List<Technology> technologyList = new ArrayList<>();
        technologyList.add(getTechnology());
        return technologyList;
    }

}