package com.bootcamp.learningSpring.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.bootcamp.learningSpring.domain.Film;

public interface FilmService {

    public Film create(Film newFilm);

    public List<Film> create(List<Film> newFilms);

    public List<Film> getAllFilms();

    public Film getFilmById(Integer id);

    public List<Film> getFilms(Film film);

    public List<Film> getFilmsByTitle(String title);

    public Film removeFilmById(Integer id);

    public Boolean remove(String title, String genre, Integer year);

}
