package com.bootcamp.learningSpring.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.bootcamp.learningSpring.domain.Film;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts={"classpath:film-schema.sql", "classpath:film-data.sql"}, executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD)
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
        Film responseBody = new Film(2, 2023, "Oppenheimer", "Historical Drama");
        String responseBodyJSON = this.mapper.writeValueAsString(responseBody);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(responseBodyJSON);
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

    }

    @Test
    void testCreate2() throws Exception {
        String fJSON = this.mapper.writeValueAsString(new Film(2023, "Oppenheimer", "Historical Drama"));
        String responseBodyJSON = this.mapper.writeValueAsString(new Film(2, 2023, "Oppenheimer", "Historical Drama"));
        this.mvc.perform(
                MockMvcRequestBuilders
                        .post("/films/create")
                        .content(fJSON)
                        .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.content().json(responseBodyJSON));
    }

    @Test
    void testGetById() throws Exception {
        final int id = 1;
        String responseBody = this.mapper.writeValueAsString(new Film(id, 2023, "Oppenheimer", "Historical Drama"));
        this.mvc.perform(MockMvcRequestBuilders.get("/films/get/" + id))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json(responseBody));
    }


    @Test
    void testGetAll() throws Exception {
        List<Film> films = new ArrayList<Film>();
        films.add(new Film(1, 2023, "Oppenheimer", "Historical Drama"));
        String responseBody = this.mapper.writeValueAsString(films);
        this.mvc.perform(MockMvcRequestBuilders.get("/films/getAll"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json(responseBody));
    }

    @Test
    void testGet() throws Exception {
        final int id = 1;
        Film partialF = new Film();
        partialF.setId(id);
        Film f = new Film(id, 2023, "Oppenheimer", "Historical Drama");
        List<Film> films = new ArrayList<Film>();
        films.add(f);
        String responseBody = this.mapper.writeValueAsString(films);
        this.mvc.perform(MockMvcRequestBuilders.get("/films/getFilms")
            .content(mapper.writeValueAsString(f)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseBody));
    }

    @Test
    void testDeleteByID() throws Exception {
        final int id = 1;
        String responseBody = this.mapper.writeValueAsString(new Film(id, 2023, "Oppenheimer", "Historical Drama"));
        this.mvc.perform(MockMvcRequestBuilders.delete("/films/remove/" + id))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json(responseBody));
    }

    @Test
    void testDelete() throws Exception {
        final int id = 1;
        Film partialF = new Film();
        partialF.setId(id);
        Film f = new Film(id, 2023, "Oppenheimer", "Historical Drama");
        List<Film> films = new ArrayList<Film>();
        films.add(f);
        String responseBody = this.mapper.writeValueAsString(films);
        this.mvc.perform(MockMvcRequestBuilders.delete("/films/remove")
            .content(mapper.writeValueAsString(f)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseBody));
    }

    @Test
    void testNotFound() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/films/get/" + 2)).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test // try and create an object that doesn't pass validation and check that the error works
    void testFailCreate() throws Exception {
        String fJSON = this.mapper.writeValueAsString(new Film(null, null, null));
        this.mvc.perform(
                MockMvcRequestBuilders
                        .post("/films/create")
                        .content(fJSON)
                        .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    };

}
