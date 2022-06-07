package com.example.testbackenddeveloper.controller;

import com.example.testbackenddeveloper.services.TechnologyService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getTechnology;
import static com.example.testbackenddeveloper.TestUtils.TestEntityFactory.getTechnologyDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TechnologyControllerTest extends AbstractMVCTest {

    @MockBean
    TechnologyService technologyService;

    @Test
    void getAllTestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/technology/"))
                .andExpect(status().isOk());
    }

    @Test
    void getByIdTestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/technology/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTechnologyTestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/technology/1"))
                .andExpect(status().isOk());
    }

    @Test
    void newTechnologyTestOk() throws Exception {

        when(technologyService.save(getTechnologyDto())).thenReturn(getTechnology());

        String newTechnology = new Gson().toJson(getTechnology());

        mockMvc.perform(post("/api/technology/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTechnology))
                .andExpect(status().isCreated());
    }

}
