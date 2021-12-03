package com.sop.movielistservice.services;

import com.sop.movielistservice.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieListService {
    private List<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie("1", "Red Notice"),
            new Movie("2", "Wrath of Man")
    ));

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(String movieId) {
        return movies.stream()
                .filter(movie -> movieId.equals(movie.getId()))
                .findFirst()
                .orElse(null);
    }
}
