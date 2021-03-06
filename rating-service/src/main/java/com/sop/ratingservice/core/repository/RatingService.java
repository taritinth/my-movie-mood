package com.sop.ratingservice.core.repository;

import com.sop.ratingservice.core.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class RatingService {
    @Autowired
    private MovieRepository movieRepository;

    private static final DecimalFormat df = new DecimalFormat("0.0");

    public boolean updateRating(String movieId, Double rating, Double movieRating, int movieVote){
        try {
            Movie movie = movieRepository.findByMovieId(movieId);
            int increaseVote = movieVote + 1;
            Double newRating = ((movieRating * movieVote)+rating)/increaseVote;
            df.setRoundingMode(RoundingMode.DOWN);
            movie.setVote(increaseVote);
            movie.setRating(Double.parseDouble(df.format(newRating)));
            movieRepository.save(movie);
            return true;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean decreaseRating(String movieId, Double rating, Double movieRating, int movieVote){
        try {
            Movie movie = movieRepository.findByMovieId(movieId);
            int decreaseVote = movieVote - 1;
            Double newRating;
            if (decreaseVote == 0){
                newRating = 0.0;
            }else {
                newRating = ((movieRating * movieVote) - rating) / decreaseVote;
            }
            df.setRoundingMode(RoundingMode.DOWN);
            movie.setVote(decreaseVote);
            movie.setRating(Double.parseDouble(df.format(newRating)));
            movieRepository.save(movie);
            return true;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public Movie getMovieById(String movieId){
        try {
            Movie movie = movieRepository.findByMovieId(movieId);
            return movie;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Movie> getAllMovie(){
        try {
            List<Movie> movie = movieRepository.findAll();
            return movie;
        } catch (Exception e) {
            return null;
        }
    }
}
