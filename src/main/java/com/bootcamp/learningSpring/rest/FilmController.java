package com.bootcamp.learningSpring.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.learningSpring.domain.Film;
import com.bootcamp.learningSpring.services.FilmService;

@RestController
@RequestMapping("films/")
public class FilmController {
    
    /*

    public Film removeFilmById(Integer id);

    public Boolean remove(String title, String genre, Integer year);
     */

    private FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Film> create(@RequestBody Film newFilm) {
        return new ResponseEntity<>(this.service.create(newFilm), HttpStatus.CREATED);
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<Film>> create(@RequestBody List<Film> newFilms) {
        return new ResponseEntity<>(this.service.create(newFilms), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Film> getAllFilms() {
        return this.service.getAllFilms();
    }

    @GetMapping("/get/{id}")
    public Film getFilm(@PathVariable int id) {
        return this.service.getFilmById(id);
    }

    @GetMapping("/getByTitle/{title}")
    public List<Film> getFilm(@PathVariable String title) {
        return this.service.getFilmsByTitle(title);
    }

    @GetMapping("/getFilms")
    public List<Film> getFilms(@RequestBody Film film) {
            return this.service.getFilms(film);
    }

    @DeleteMapping("/remove/{id}")
    public Film removeFilm(@PathVariable int id) {
        return this.service.removeFilmById(id);
    }

    @DeleteMapping("/remove")
    public Boolean remove(
        @RequestParam(name="title", required=false) String title, 
        @RequestParam(name="genre", required=false) String genre, 
        @RequestParam(name="year", required=false) Integer year) {
        return this.service.remove(title, genre, year);
    }
}
