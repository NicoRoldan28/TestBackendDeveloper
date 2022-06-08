package com.example.testbackenddeveloper.models.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDto {
    private String name;
    @NotBlank
    private String version;
}
