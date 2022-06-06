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
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tecnologia")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long technologyId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "version")
    private String version;
}
