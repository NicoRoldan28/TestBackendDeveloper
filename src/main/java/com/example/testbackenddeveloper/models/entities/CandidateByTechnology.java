package com.example.testbackenddeveloper.models.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "candidato_x_terconologia")
public class CandidateByTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_candidato_x_tecnologia")
    private Integer id;

    @JoinColumn(name = "candidateId", referencedColumnName = "candidateId")
    @ManyToOne
    private Candidate candidate;

    @JoinColumn(name = "technologyId", referencedColumnName = "technologyId")
    @ManyToOne
    private Technology technology;

    @Column(name = "yearsOfExperience")
    private Long yearsOfExperience;
}
