/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.reviewservice.command.rest;

import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/review")
public class MovieReviewPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final CommandGateway commandGateway;

    @Autowired
    public MovieReviewPublisher(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(value = "/addReview")
    public boolean addMovieReview(@RequestBody Review review, @RequestHeader(value = "email") String email) {
        review.setUserEmail(email);
        boolean status = (boolean) rabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "addReview", review);
        return status;
    }

    @GetMapping(value = "/getReview/{movieId}")
    public List<Review> getMovieReview(@PathVariable("movieId") String movieId) {
//        MovieReview mr = new MovieReview(movieName, score, review, reviewBy);
        List<Review> reviews = (List<Review>) rabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "getReview", movieId);
        return reviews;
    }


}