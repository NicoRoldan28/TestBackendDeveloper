package com.example.testbackenddeveloper.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "candidato_x_tecnologia")
public class CandidateByTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato_x_tecnologia")
    private Long id;

    @JoinColumn(name = "candidateId", referencedColumnName = "candidateId")
    @ManyToOne
    private Candidate candidate;

    @JoinColumn(name = "technologyId", referencedColumnName = "technologyId")
    @ManyToOne
    private Technology technology;

    @Column(name = "yearsOfExperience")
    private Long yearsOfExperience;
}
