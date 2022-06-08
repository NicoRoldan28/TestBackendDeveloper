package com.example.testbackenddeveloper.controller;

import com.example.testbackenddeveloper.services.CandidateByTechnologyService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateByTechnology;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateByTechnologyDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CandidateByTechnologyControllerTest extends AbstractMVCTest {

    @MockBean
    CandidateByTechnologyService candidateByTechnologyService;

    @Test
    void getAllTestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/candidatoByTechnology/"))
                .andExpect(status().isOk());
    }

    @Test
    void getByIdTestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/candidatoByTechnology/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getByNameTechnologyTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/candidatoByTechnology/nameTechnology/java"))
                .andExpect(status().isOk());
    }

    @Test
    void newCandidateByTechnologyTestOk() throws Exception {

        when(candidateByTechnologyService.save(getCandidateByTechnologyDto())).thenReturn(getCandidateByTechnology());

        String newCandidateByTechnology = new Gson().toJson(getCandidateByTechnology());

        mockMvc.perform(post("/api/candidatoByTechnology/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newCandidateByTechnology))
                .andExpect(status().isCreated());
    }
}
