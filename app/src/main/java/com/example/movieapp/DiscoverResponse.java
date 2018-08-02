package com.example.movieapp;

import java.util.List;

public class DiscoverResponse {
    private List<Discover> results;

    public DiscoverResponse(List<Discover> results) {
        this.results = results;
    }

    public List<Discover> getResults() {
        return results;
    }

    public void setResults(List<Discover> results) {
        this.results = results;
    }

    public DiscoverResponse() {

    }

    public void trim() {

    }
}
