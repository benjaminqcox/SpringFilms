package com.bootcamp.learningSpring.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="releaseYear")
    @NotNull
    @Range(min=1850, max=2100)
    private Integer year;

    @NotEmpty
    @Size(max=32)
    private String title;

    @NotNull
    @Size(max=32)
    private String genre;

    public Film() {

    }

    public Film(Integer year, String title, String genre) {
        this.year = year;
        this.title = title;
        this.genre = genre;
    }

    public Film(Integer id, Integer year, String title, String genre) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Film: \n\ttitle: " + getTitle() + "\n\tYear: " + getYear() + "\n\tGenre: " + getGenre();
    }

}
