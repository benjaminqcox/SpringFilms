package com.bootcamp.learningSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bootcamp.learningSpring.domain.Film;

@Primary
@Service
public class FilmServiceList implements FilmService {
    public List<Film> films = new ArrayList<Film>();

    @Override
    public Film create(Film newFilm) {
        System.out.println("Adding film: " + newFilm);
        films.add(newFilm);
        Film filmCreated = films.get(films.size() - 1);
        return filmCreated;
    }

    @Override
    public List<Film> create(List<Film> newFilms) {
        System.out.println("Adding films: " + newFilms);
        films.addAll(newFilms);
        List<Film> filmsCreated = films.subList(films.size() - newFilms.size(), films.size());
        return filmsCreated;
    }

    @Override
    public List<Film> getAllFilms() {
        return films;
    }

    @Override
    public Film getFilm(int id) {
        Film filmFound = films.get(id);
        System.out.println(filmFound);
        return filmFound;
    }

    @Override
    public Film removeFilm(int id) {
        return films.remove((int) id);
    }

    @Override
    public Boolean remove(String title, String genre, Integer year) {
        int initSize = films.size();
        System.out.println("Current film list:\n" + films);
        films.removeIf(f -> f.getTitle().equals(title) || f.getGenre().equals(genre) || f.getYear().equals(year));
        System.out.println("New films list:\n" + films);
        return films.size() < initSize;
    }
}