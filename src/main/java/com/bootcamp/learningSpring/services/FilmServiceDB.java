package com.bootcamp.learningSpring.services;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bootcamp.learningSpring.domain.Film;

@Primary
@Service
public class FilmServiceDB implements FilmService {

    @Override
    public Film create(Film newFilm) {
        return null;
    }

    @Override
    public List<Film> create(List<Film> newFilms) {
        return null;
    }

    @Override
    public List<Film> getAllFilms() {
        return null;
    }

    @Override
    public Film getFilm(int id) {
        return null;
    }

    @Override
    public Film removeFilm(int id) {
        return null;
    }

    @Override
    public Boolean remove(String title, String genre, Integer year) {
        return null;
    }
}
