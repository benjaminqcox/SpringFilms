package com.bootcamp.learningSpring.services;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bootcamp.learningSpring.domain.Film;
import com.bootcamp.learningSpring.exceptions.FilmNotFoundException;
import com.bootcamp.learningSpring.repos.FilmRepo;

@Primary
@Service
public class FilmServiceDB implements FilmService {

    private FilmRepo repo;

    public FilmServiceDB(FilmRepo repo) {
        this.repo = repo;
    }

    @Override
    public Film create(Film newFilm) {
        return this.repo.save(newFilm);
    }

    @Override
    public List<Film> create(List<Film> newFilms) {
        return this.repo.saveAll(newFilms);
    }

    @Override
    public List<Film> getAllFilms() {
        return this.repo.findAll();
    }

    @Override
    public Film getFilmById(Integer id) {
        return this.repo.findById(id).orElseThrow(() -> new FilmNotFoundException());
    }

    @Override
    public Film removeFilmById(Integer id) {
        Film filmRemoved = this.repo.findById(id).orElseThrow(FilmNotFoundException::new);
        this.repo.deleteById(id);
        return filmRemoved;
    }

    @Override
    public Boolean remove(String title, String genre, Integer year) {
        return false;
    }

    @Override
    public List<Film> getFilms(Film film) {
        return this.repo.findAll(Example.of(film));
    }

    @Override
    public List<Film> getFilmsByTitle(String title) {
        return this.repo.findByTitleContainsIgnoreCase(title);
    }
}
