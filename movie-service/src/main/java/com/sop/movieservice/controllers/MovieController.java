package com.sop.movieservice.controllers;

import com.sop.movieservice.entities.Movie;
import com.sop.movieservice.repository.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/getMovieByName")
    public ResponseEntity<?> getMovieByName(@RequestParam String s){
        return ResponseEntity.ok(movieService.getMovieByName(s));
    }

    @PostMapping(value = "/addMovie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie, @RequestHeader(value = "role") String role){
        if (!role.equals("admin")){
            return new ResponseEntity<>("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping(value = "/editMovie")
    public ResponseEntity<?> editMovie(@RequestBody Movie movie, @RequestHeader(value = "role") String role){
        if (!role.equals("admin")){
            return new ResponseEntity<>("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(movieService.editMovie(movie));
    }

    @PostMapping(value = "/deleteMovie")
    public ResponseEntity<?> deleteMovie(@RequestBody Movie movie, @RequestHeader(value = "role") String role){
        if (!role.equals("admin")){
            return new ResponseEntity<>("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(movieService.deleteMovie(movie));
    }


//    public MovieController(final MovieService movieListService){
//        this.movieService = movieService;
//    }

    @GetMapping(value = "/getMovieById/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") String movieId){
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }

    @GetMapping(value = "/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }


}
