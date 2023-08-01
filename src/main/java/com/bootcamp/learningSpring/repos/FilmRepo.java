package com.bootcamp.learningSpring.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.learningSpring.domain.Film;


@Repository
public interface FilmRepo extends JpaRepository<Film, Integer> {
    
    @Query(value="SELECT title FROM film WHERE genre=?1", nativeQuery=true)
    List<String> findTitleByGenre(String genre);

    @Query(value="SELECT year FROM film WHERE title=?1", nativeQuery=true)
    Integer findYearByTitle(Integer year);

    // @Query(value="SELECT * FROM film WHERE title=?1 AND genre=?2 AND year=?3", nativeQuery=true)
    // List<Film> findBy(String title, String genre, Integer year);

    List<Film> findAll();

    List<Film> findByTitleContainsIgnoreCase(String title);

    List<Film> findByYear(Integer year);

    List<Film> findByGenre(String genre);

}
