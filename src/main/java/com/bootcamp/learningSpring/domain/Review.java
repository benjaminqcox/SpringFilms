package com.bootcamp.learningSpring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(targetEntity=Film.class)
    private Film film;

    @NotNull
    @Range(min=1, max=5)
    private Integer rating;

    @NotEmpty
    @Size(max=32)
    private String title;

    @NotEmpty
    @Size(max=128)
    private String comment;

    public Review(Integer id, Film film, Integer rating, String title, String comment) {
        this.id = id;
        this.film = film;
        this.rating = rating;
        this.title = title;
        this.comment = comment;
    }

    public Review(Integer rating, Film film, String title, String comment) {
        this.film = film;
        this.rating = rating;
        this.title = title;
        this.comment = comment;
    }

    public Review() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Film getFilm() {
        return this.film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
