package com.bootcamp.learningSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.learningSpring.domain.Film;

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
    public Film getFilmById(Integer id) {
        Film filmFound = films.get((int) id);
        System.out.println(filmFound);
        return filmFound;
    }


    @Override
    public List<Film> remove(Film f) {
        int initSize = films.size();
        System.out.println("Current film list:\n" + films);
        //films.removeIf(f -> f.getTitle().equals(title) || f.getGenre().equals(genre) || f.getYear().equals(year));
        System.out.println("New films list:\n" + films);
        return List.of(f);//films.size() < initSize;
    }

    @Override
    public Film removeFilmById(Integer id) {
        return films.remove((int) id);
    }

    @Override
    public List<Film> getFilms(Film film) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFilms'");
    }

    @Override
    public List<Film> getFilmsByTitle(String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFilmsByTitle'");
    }

    @Override
    public Film updateFilmById(Integer id, String title, String genre, Integer year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateFilmById'");
    }
}