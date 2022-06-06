package com.example.testbackenddeveloper.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Candidate {

    @Id
    private long id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthday;

}
