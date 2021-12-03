package com.sop.movielistservice.controllers;

import com.sop.movielistservice.entities.Movie;
import com.sop.movielistservice.services.MovieListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieListController {

    private final MovieListService movieListService;

    @Autowired
    public MovieListController(final MovieListService movieListService){
        this.movieListService = movieListService;
    }

    @GetMapping(value = "/getMovieById/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") String movieId){
        return ResponseEntity.ok(movieListService.getMovieById(movieId));
    }

    @GetMapping(value = "/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieListService.getAllMovies());
    }


}
