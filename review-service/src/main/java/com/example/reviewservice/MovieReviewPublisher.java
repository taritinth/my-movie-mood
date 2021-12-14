package com.example.reviewservice;

import com.example.reviewservice.entities.Review;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/review")
public class MovieReviewPublisher {
    @Autowired
    private RabbitTemplate RabbitTemplate;

    @PostMapping(value = "/addReview")
    public boolean addMovieReview(@RequestBody Review review) {
//        MovieReview mr = new MovieReview(movieName, score, review, reviewBy);
        boolean status = (boolean) RabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "addReview", review);
        return status;
    }

    @GetMapping(value = "/getReview/{movieId}")
    public List<Review> getMovieReview(@PathVariable("movieId") String movieId) {
//        MovieReview mr = new MovieReview(movieName, score, review, reviewBy);
        List<Review> reviews = (List<Review>) RabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "getReview", movieId);
        return reviews;
    }

}

