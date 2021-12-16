package com.appsdeveloperblog.estore.reviewservice.core.repository;

import com.appsdeveloperblog.estore.reviewservice.core.entities.Movie;
import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;
import com.appsdeveloperblog.estore.reviewservice.core.events.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Review> getReviewByMovieId(String movieId) {
        try {
            return repository.findByMovieId(movieId);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addReview(Review review) {
        try {
            Review checkReviewId = repository.findByReviewId(review.getReviewId());
            if(checkReviewId == null){
                review.setTimestamp(new Timestamp(System.currentTimeMillis()));
                repository.save(review);
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public Movie getMovieById(String movieId){
        try {
            Movie movie = movieRepository.findByMovieId(movieId);
            System.out.println("gettid");
            return movie;
        } catch (Exception e) {
            System.out.println("get maitid");
            return null;
        }
    }
}
