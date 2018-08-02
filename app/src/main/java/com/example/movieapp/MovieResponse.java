package com.example.movieapp;

import java.util.List;

public class MovieResponse {
    private List<Movie> movie_results;

    public MovieResponse() {
    }

    public MovieResponse(List<Movie> movies) {
        this.movie_results = movies;
    }

    public List<Movie> getMovies() {
        return movie_results;
    }

    public void setMovies(List<Movie> movies) {
        this.movie_results = movies;
    }
}
