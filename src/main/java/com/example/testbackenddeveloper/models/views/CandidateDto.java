package com.example.testbackenddeveloper.models.views;

import com.example.testbackenddeveloper.models.entities.CandidateByTechnology;
import com.example.testbackenddeveloper.models.enums.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
    private String name;
    private String lastName;
    private Type type;
    private String dni;
    @JsonFormat(timezone = "yyyy-MM-dd")
    private LocalDate birthday;
    private List<CandidateByTechnology> candidateByTechnologies;
}
