package com.example.testbackenddeveloper.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Technology {

    @Id
    private long id;
    private String name;
    private String version;
}
