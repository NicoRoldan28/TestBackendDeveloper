package com.example.testbackenddeveloper.models.entities;

import com.example.testbackenddeveloper.models.enums.Type;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "candidatos")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Type type;

    @Column(name = "dni")
    private String dni;

    @JsonFormat(timezone = "yyyy-MM-dd")
    private LocalDate birthday;

    @OneToMany(mappedBy = "candidate")
    @JsonBackReference
    private List<CandidateByTechnology> candidateByTechnologies;

}
