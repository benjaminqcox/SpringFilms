package com.bootcamp.learningSpring.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bootcamp.learningSpring.domain.Film;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FilmMvcTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        // METHOD: POST
        // PATH: /hedgehog/create
        // BODY: JSON
        // HEADERS: CONTENT-TYPE: application\json
        Film f = new Film(2023, "Oppenheimer", "Historical Drama");
        String fJSON = this.mapper.writeValueAsString(f);
        RequestBuilder req = MockMvcRequestBuilders.post("/films/create").content(fJSON).contentType(MediaType.APPLICATION_JSON);
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        Film responseBody = new Film(1, 2023, "Oppenheimer", "Historical Drama");
        String responseBodyJSON = this.mapper.writeValueAsString(responseBody);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(responseBodyJSON);
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

    }

    @Test
    void testCreate2() throws Exception {
        String fJSON = this.mapper.writeValueAsString(new Film(2023, "Oppenheimer", "Historical Drama"));
        String responseBodyJSON = this.mapper.writeValueAsString(new Film(1, 2023, "Oppenheimer", "Historical Drama"));
        this.mvc.perform(
                MockMvcRequestBuilders.
                        post("/films/create")
                        .content(fJSON)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(responseBodyJSON));
    }
}
