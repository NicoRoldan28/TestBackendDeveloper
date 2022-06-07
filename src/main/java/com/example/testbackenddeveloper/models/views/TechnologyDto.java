package com.example.testbackenddeveloper.models.views;

import com.example.testbackenddeveloper.models.entities.CandidateByTechnology;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDto {
    private String name;
    private String version;
    private List<CandidateByTechnology> candidateByTechnologies;
}
