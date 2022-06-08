package com.example.testbackenddeveloper.models.views;

import com.example.testbackenddeveloper.models.enums.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {

    @NotNull(message = "El nombre no puede ser nulo")
    private String name;
    @NotNull(message = "El nombre no puede ser nulo")
    private String lastName;
    @NotNull
    private Type type;
    @Size(min = 8, max = 8, message = "El numero de dni tiene 8 caracteres")
    private String dni;
    @PastOrPresent
    @JsonFormat(timezone = "yyyy-MM-dd")
    private LocalDate birthday;
}
