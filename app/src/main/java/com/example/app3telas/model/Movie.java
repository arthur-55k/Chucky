package com.example.app3telas.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String genre;
    private int year;
    private double rating;
    private String synopsis;
    private String director;
    private String cast;
    private int imageResId;

    public Movie(String title, String genre, int year, double rating, String synopsis, String director, String cast, int imageResId) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public double getRating() { return rating; }
    public String getSynopsis() { return synopsis; }
    public String getDirector() { return director; }
    public String getCast() { return cast; }
    public int getImageResId() { return imageResId; }
}
