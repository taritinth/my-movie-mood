package com.sop.movieservice.controllers;

import com.sop.movieservice.entities.Movie;
import com.sop.movieservice.repository.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/getMovieByName/{serchTerm}")
    public ResponseEntity<List<Movie>> getMovieByName(@PathVariable("serchTerm") String name){
        return ResponseEntity.ok(movieService.getMovieByName(name));
    }

//    public MovieController(final MovieService movieListService){
//        this.movieService = movieService;
//    }

//    @GetMapping(value = "/getMovieById/{movieId}")
//    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") String movieId){
//        return ResponseEntity.ok(movieService.getMovieById(movieId));
//    }

    @GetMapping(value = "/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }


}
