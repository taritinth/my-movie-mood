package com.example.reviewservice.repository;

import com.example.reviewservice.entities.Review;
import org.axonframework.config.ProcessingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@ProcessingGroup("review-group")
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    public List<Review> getReviewByMovieId(String movieId) {
        try {
            return repository.findByMovieId(movieId);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addReview(Review review) {
        try {
            repository.insert(review);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
