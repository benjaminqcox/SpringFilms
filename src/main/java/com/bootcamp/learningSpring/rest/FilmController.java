package com.bootcamp.learningSpring.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.learningSpring.domain.Film;

@RestController
public class FilmController {
    
    public  List<Film> films = new ArrayList<Film>();

    @PostMapping("/create")
    public ResponseEntity<Film> create(@RequestBody Film newFilm) {
        System.out.println("Adding film: " + newFilm);
        films.add(newFilm);
        Film filmCreated = films.get(films.size() - 1);
        return new ResponseEntity<>(filmCreated, HttpStatus.CREATED);
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<Film>> create(@RequestBody List<Film> newFilms) {
        System.out.println("Adding films: " + newFilms);
        films.addAll(newFilms);
        List<Film> filmsCreated = films.subList(films.size() - newFilms.size(), films.size());
        return new ResponseEntity<>(filmsCreated, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Film> getAllFilms() {
        return films;
    }

    @GetMapping("/get/{id}")
    public Film getFilm(@PathVariable Integer id) {
        Film filmFound = films.get(id);
        System.out.println(filmFound);
        return filmFound;
    }

    @DeleteMapping("/remove/{id}")
    public Film deleteFilm(@PathVariable Integer id) {
        return films.remove((int) id);
    }

    @DeleteMapping("/remove")
    public Boolean remove(
        @PathParam("title") String title, 
        @PathParam("genre") String genre, 
        @PathParam("year") Integer year) {
        int initSize = films.size();
        System.out.println("Current film list:\n" + films);
        films.removeIf(f -> f.getTitle().equals(title) || f.getGenre().equals(genre) || f.getYear().equals(year));
        System.out.println("New films list:\n" + films);
        return films.size() < initSize;
    }
}
