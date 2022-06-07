package com.example.testbackenddeveloper.TestUtils;

import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.models.enums.Type;
import com.example.testbackenddeveloper.models.views.CandidateDto;
import com.example.testbackenddeveloper.models.views.TechnologyDto;

import java.time.LocalDate;

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
                //.birthday(birthday)
                .candidateByTechnologies(null)
                .build();
        return candidateDto;
    }

    public static Candidate getCandidate() {
        LocalDate birthday = LocalDate.of(2022, 4, 4);
        Candidate candidate = Candidate.builder()
                .candidateId(1L)
                .candidateByTechnologies(null)
                .dni("12313")
                .name("nicolas")
                .lastName("roldan")
                //.birthday(birthday)
                .type(Type.DNI)
                .build();
        return candidate;
    }


}
