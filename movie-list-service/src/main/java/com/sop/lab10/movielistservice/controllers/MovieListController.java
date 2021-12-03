package com.sop.lab10.movielistservice.controllers;

import com.sop.lab10.movielistservice.services.MovieListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieListController {

    private final MovieListService movieListService;

    @Autowired
    public MovieListController(final MovieListService movieListService){
        this.movieListService = movieListService;
    }

    @GetMapping(value = "/getMovie/{movieId}")
    public ResponseEntity<String> test(@PathVariable("movieId") String movieId){
        return ResponseEntity.ok(movieListService.getMovie(movieId));
    }
}
