package com.bootcamp.learningSpring.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.bootcamp.learningSpring.domain.Film;
import com.bootcamp.learningSpring.repos.FilmRepo;
import com.bootcamp.learningSpring.services.FilmService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts={"classpath:film-schema.sql", "classpath:film-data.sql"}, executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class FilmServiceDBUnitTest {
    
    @Autowired
    private FilmService service;

    @MockBean
    private FilmRepo repo;


    @Test
    void testCreate() {
        // GIVEN
        Film f = new Film(2023, "Oppenheimer", "Historical Drama");
        Film savedF = new Film(2, 2023, "Oppenheimer", "Historical Drama");

        // WHEN
        Mockito.when(this.repo.save(f)).thenReturn(savedF);

        // THEN
        Assertions.assertEquals(savedF, this.service.create(f));

        Mockito.verify(this.repo, Mockito.times(1)).save(f);
    }

    @Test
    void testGet() {
        // GIVEN
        final int id = 1;
        Film f = new Film(id, 2023, "Oppenheimer", "Historical Drama");

        // WHEN
        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(f));

        // THEN
        Assertions.assertEquals(f, this.service.getFilmById(id));

        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    }

    @Test
    void testGetAll() {
        // GIVEN
        Film f1 = new Film(2023, "Oppenheimer", "Historical Drama");
        
        // WHEN
        Mockito.when(this.repo.findAll()).thenReturn(java.util.List.of(f1));

        // THEN
        Assertions.assertEquals(java.util.List.of(f1), this.service.getAllFilms());

        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

    @Test
    void testUpdate() {
        // GIVEN
        final int id = 1;
        Film f = new Film(id, 2023, "Oppenheimer", "Historical Drama");
        Film updatedF = new Film(id, 2021, "Oppenheimer 0.5", "History");

        // WHEN
        Mockito.when(this.repo.findById(id)).thenReturn(java.util.Optional.of(f));
        Mockito.when(this.repo.save(updatedF)).thenReturn(updatedF);

        // THEN
        Assertions.assertEquals(updatedF, this.service.updateFilmById(id, updatedF.getTitle(), updatedF.getGenre(), updatedF.getYear()));

        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(updatedF);
    }

    @Test
    void testDelete() {
        // GIVEN
        final int id = 1;
        Film f = new Film(id, 2023, "Oppenheimer", "Historical Drama");

        // WHEN
        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(f));

        // THEN
        Assertions.assertEquals(f, this.service.removeFilmById(id));

        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    }
}
