package com.example.testbackenddeveloper.TestUtils;

import com.example.testbackenddeveloper.models.entities.Technology;
import com.example.testbackenddeveloper.models.views.TechnologyDto;

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
                .name("java")
                .version("11.0")
                .candidateByTechnologies(null)
                .build();

        return technology;
    }
}
