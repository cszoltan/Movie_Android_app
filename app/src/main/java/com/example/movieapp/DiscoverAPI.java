package com.example.movieapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DiscoverAPI {
    @GET("/3/discover/movie")
    Call<DiscoverResponse> movieDetails(
            @Query("api_key") String api,
            @Query("sort_by") String sorting,
            @Query("year") Integer year
    );
}
