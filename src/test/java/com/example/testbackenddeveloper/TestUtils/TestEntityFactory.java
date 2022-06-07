package com.example.testbackenddeveloper.TestUtils;

import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.models.enums.Type;
import com.example.testbackenddeveloper.models.views.CandidateDto;
import com.example.testbackenddeveloper.models.views.TechnologyDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestEntityFactory {

    public static TechnologyDto getTechnologyDto() {
        TechnologyDto technologyDto = TechnologyDto.builder()
                .name("java")
                .version("11.0")
                .candidateByTechnologies(null)
                .build();

        return technologyDto;
    }

    public static Technology getTechnology() {
        Technology technology = Technology.builder()
                .technologyId(1L)
                .name("java")
                .version("11.0")
                .candidateByTechnologies(null)
                .build();

        return technology;
    }

    public static CandidateDto getCandidateDto() {
        LocalDate birthday = LocalDate.of(2022, 4, 4);
        CandidateDto candidateDto = CandidateDto.builder()
                .dni("12313")
                .name("nicolas")
                .lastName("roldan")
                .type(Type.DNI)
                .candidateByTechnologies(null)
                .build();
        return candidateDto;
    }

    public static Candidate getCandidate() {
        LocalDate birthday = LocalDate.of(2022, 4, 4);
        Candidate candidate = Candidate.builder()
                .candidateId(1L)
                .dni("12313")
                .name("nicolas")
                .lastName("roldan")
                .type(Type.DNI)
                .candidateByTechnologies(null)
                .build();
        return candidate;
    }

    public static Candidate getCandidateWithoutId() {
        Candidate candidate = Candidate.builder()
                .dni("12313")
                .name("nicolas")
                .lastName("roldan")
                .type(Type.DNI)
                .candidateByTechnologies(null)
                .build();
        return candidate;
    }

    public static List<Candidate> getCandidateList() {
        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(getCandidate());
        return candidateList;
    }

    public static List<CandidateDto> getCandidateDtoList() {
        List<CandidateDto> candidateDtoList = new ArrayList<>();
        candidateDtoList.add(getCandidateDto());
        return candidateDtoList;
    }


}
