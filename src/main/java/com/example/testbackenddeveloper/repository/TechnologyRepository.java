package com.example.testbackenddeveloper.repository;

import com.example.testbackenddeveloper.models.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology,Long> {
}
