package com.example.reviewservice;

import com.example.reviewservice.entities.Review;
import com.example.reviewservice.repository.ReviewService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieReviewConsumer {

    @Autowired
    private ReviewService reviewService;

    @RabbitListener(queues = "AddMovieReviewQueue")
    public boolean addMovieReview(Review review) {
        return reviewService.addReview(review);
    }

    @RabbitListener(queues = "GetMovieReviewQueue")
    public List<Review> getReviewByMovieId(String movieId){
        return reviewService.getReviewByMovieId(movieId);
    }

}