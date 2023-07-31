package com.bootcamp.learningSpring.domain;

public class Film {
    private Integer year;

    private String name;

    private String genre;

    public Film() {

    }

    public Film(Integer year, String name, String genre) {
        this.year = year;
        this.name = name;
        this.genre = genre;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Film: \n\tName: " + getName() + "\n\tYear: " + getYear() + "\n\tGenre: " + getGenre();
    }

}
