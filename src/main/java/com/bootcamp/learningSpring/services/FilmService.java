package com.bootcamp.learningSpring.services;

import java.util.List;

import com.bootcamp.learningSpring.domain.Film;

public interface FilmService {

    public Film create(Film newFilm);

    public List<Film> create(List<Film> newFilms);

    public List<Film> getAllFilms();

    public Film getFilm(int id);

    public Film removeFilm(int id);

    public Boolean remove(String title, String genre, Integer year);

}
