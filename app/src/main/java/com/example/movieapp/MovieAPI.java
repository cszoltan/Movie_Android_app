package com.example.movieapp;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieAPI {
    @GET("/3/find/{id}?api_key=73fc903f862d78126b18ed88a8013f59&external_source=imdb_id")
    Call<MovieResponse> movieDetails(
            @Path("id") String id
    );
}