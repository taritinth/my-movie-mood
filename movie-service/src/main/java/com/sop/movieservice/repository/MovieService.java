package com.sop.movieservice.repository;

import com.sop.movieservice.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> getAllMovies() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

}
