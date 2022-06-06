package com.example.testbackenddeveloper.repository;

import com.example.testbackenddeveloper.models.entities.CandidateByTechnology;
import com.example.testbackenddeveloper.projection.CandidateByTechnologyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateByTechnologyRepository extends JpaRepository<CandidateByTechnology,Long> {

    @Query(value = "SELECT C.NOMBRE,C.APELLIDO, C.DNI,C.BIRTHDAY , T.VERSION FROM CANDIDATO_X_TECNOLOGIA CT " +
            "LEFT JOIN CANDIDATOS C " +
            "ON CT.CANDIDATE_ID = C.CANDIDATE_ID " +
            "LEFT JOIN TECNOLOGIAS T " +
            "ON CT.TECHNOLOGY_ID = T.TECHNOLOGY_ID " +
            "WHERE T.NOMBRE = ?1 ",nativeQuery = true)
    List<CandidateByTechnologyProjection> getByNameTechnology(String name);

}
