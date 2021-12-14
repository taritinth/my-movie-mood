package com.example.reviewservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieReviewPublisher {
    @Autowired
    private RabbitTemplate RabbitTemplate;

    @RequestMapping(value = "/addMovieReview", method = RequestMethod.GET)
    public String addMovieReview(@RequestParam("movie") String movieName, @RequestParam("score") double score, @RequestParam("review") String review, @RequestParam("reviewby") String reviewBy) {
        MovieReview mr = new MovieReview(movieName, score, review, reviewBy);
        RabbitTemplate.convertAndSend("MyMovieMoodDirect", "review", mr);
        return "Complete";
    }

}

