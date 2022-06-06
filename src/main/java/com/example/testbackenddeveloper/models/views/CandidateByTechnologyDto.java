package com.example.testbackenddeveloper.models.views;

import com.example.testbackenddeveloper.models.entities.Candidate;
import com.example.testbackenddeveloper.models.entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateByTechnologyDto {

    private Candidate candidate;
    private Technology technology;
    private Long yearsOfExperience;
}
