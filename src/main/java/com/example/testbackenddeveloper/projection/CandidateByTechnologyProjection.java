package com.example.testbackenddeveloper.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface CandidateByTechnologyProjection {

    @Value("#{target.nombre}")
    void setName(String name);

    @Value("#{target.nombre}")
    String getName();

    @Value("#{target.apellido}")
    String getLastName();
    @Value("#{target.apellido}")
    void setLastName(String lastName);

    @Value("#{target.dni}")
    void setDni(String dni);
    @Value("#{target.dni}")
    String getDni();

    @Value("#{target.birthday}")
    void setBirthday(LocalDate birthday);
    @Value("#{target.birthday}")
    LocalDate getBirthday();

    @Value("#{target.version}")
    void setVersion(String version);
    @Value("#{target.version}")
    String getVersion();
}
