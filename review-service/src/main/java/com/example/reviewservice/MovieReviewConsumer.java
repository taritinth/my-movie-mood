package com.example.reviewservice;

import com.example.reviewservice.entities.Review;
import com.example.reviewservice.event.CalculateRatingEvent;
import com.example.reviewservice.repository.ReviewService;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Aggregate
public class MovieReviewConsumer {

    @Autowired
    private ReviewService reviewService;

    @AggregateIdentifier
    private String movieId;
    private double rating;

    @RabbitListener(queues = "AddMovieReviewQueue")
    public boolean addMovieReview(Review review) {
        CalculateRatingEvent calculateRatingEvent = CalculateRatingEvent.builder()
                .movieId(review.getMovieId())
                .rating(review.getRating())
                .build();

        AggregateLifecycle.apply(calculateRatingEvent);

//        return reviewService.addReview(review);
        return true;
    }

    @RabbitListener(queues = "GetMovieReviewQueue")
    public List<Review> getReviewByMovieId(String movieId){
        return reviewService.getReviewByMovieId(movieId);
    }

}