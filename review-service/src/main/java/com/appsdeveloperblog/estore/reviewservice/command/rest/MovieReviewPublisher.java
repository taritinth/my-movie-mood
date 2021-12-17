/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.reviewservice.command.rest;

import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;

import com.appsdeveloperblog.estore.reviewservice.core.entities.ReviewQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addMovieReview(@RequestBody Review review, @RequestHeader(value = "email") String email, @RequestHeader(value = "id") String id) {
        if (review.getReviewBy().equals(id)) {
            review.setUserEmail(email);
            boolean status = (boolean) rabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "addReview", review);
            return ResponseEntity.ok(status);
        }else{
            return new ResponseEntity<>("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/getReview/{movieId}")
    public List<Review> getMovieReview(@PathVariable("movieId") String movieId) {
        List<Review> reviews = (List<Review>) rabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "getReview", movieId);
        return reviews;
    }

    @PostMapping(value = "/delReview")
    public ResponseEntity<?> deleteMovieReview(@RequestBody Review review, @RequestHeader(value = "id") String id, @RequestHeader(value = "role") String role) {
        if (review.getReviewBy().equals(id) || role.equals("admin")){
            boolean status = (boolean) rabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "delReview", review);
            return ResponseEntity.ok(status);
        }else{
            return new ResponseEntity<>("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/getAllReviews")
    public ResponseEntity<?> getAllReviews(@RequestHeader(value = "role") String role) {
        if(role.equals("admin")){
            System.out.println("get all in publisher");
            List<ReviewQuery> reviews = (List<ReviewQuery>) rabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "getAllReviews","get all");
            return ResponseEntity.ok(reviews);
        }else{
            return new ResponseEntity<>("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
    }


}
