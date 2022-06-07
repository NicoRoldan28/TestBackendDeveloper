package com.example.testbackenddeveloper.controller;

import com.example.testbackenddeveloper.services.CandidateService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidate;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getCandidateDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CandidateControllerTest extends AbstractMVCTest {

    @MockBean
    CandidateService candidateService;

    @Test
    void getAllTestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/candidate/"))
                .andExpect(status().isOk());
    }

    @Test
    void getByIdTestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/candidate/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCandidateTestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/candidate/1"))
                .andExpect(status().isOk());
    }

    @Test
    void newCandidateTestOk() throws Exception {

        when(candidateService.save(getCandidateDto())).thenReturn(getCandidate());

        String newCandidate = new Gson().toJson(getCandidate());

        mockMvc.perform(post("/api/candidate/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newCandidate))
                .andExpect(status().isCreated());
    }
}
