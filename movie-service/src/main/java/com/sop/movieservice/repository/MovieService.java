package com.sop.movieservice.repository;

import com.sop.movieservice.entities.Movie;
import com.sop.movieservice.entities.MovieImdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public boolean addMovie(Movie movie) {
        try {
            repository.save(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editMovie(Movie movie) {
        try {
            repository.save(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteMovie(Movie movie) {
        try {
            repository.delete(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Movie> getAllMovies() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Movie> getMovieByName(String name) {
        try {
            return repository.findByMovieName(name);
        } catch (Exception e) {
            return null;
        }
    }

    public Movie getMovieById(String id) {
        try {
            Movie movie = repository.findByMovieId(id);
            MovieImdb out = WebClient.create()
                    .get()
                    .uri("http://www.omdbapi.com/?apikey=96475f3d&i=" + movie.getImdbId())
                    .retrieve()
                    .bodyToMono(MovieImdb.class)
                    .block();

            movie.setImdbRating(Double.parseDouble(out.getImdbRating()));

            return movie;
        } catch (Exception e) {
            return null;
        }
    }

}
