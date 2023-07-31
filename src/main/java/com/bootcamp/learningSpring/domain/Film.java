package com.bootcamp.learningSpring.domain;

public class Film {
    private Integer year;

    private String title;

    private String genre;

    public Film() {

    }

    public Film(Integer year, String title, String genre) {
        this.year = year;
        this.title = title;
        this.genre = genre;
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
