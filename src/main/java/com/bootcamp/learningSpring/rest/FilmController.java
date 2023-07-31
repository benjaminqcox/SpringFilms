package com.bootcamp.learningSpring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.learningSpring.domain.Film;

@RestController
public class FilmController {
    
    private List<Film> films = new ArrayList<Film>();

    @PostMapping("/create")
    public ResponseEntity<Film> create(@RequestBody Film film) {
        System.out.println("Adding film: " + film);
        films.add(film);
        Film filmCreated = films.get(films.size() - 1);
        return new ResponseEntity<>(filmCreated, HttpStatus.CREATED);
    }
    
}
