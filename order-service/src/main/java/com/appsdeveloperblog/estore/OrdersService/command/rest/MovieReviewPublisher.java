/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.OrdersService.command.rest;

import com.appsdeveloperblog.estore.OrdersService.core.POJO.Review;
import com.appsdeveloperblog.estore.OrdersService.command.commands.CreateReviewCommand;

import javax.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/review")
public class MovieReviewPublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    private final CommandGateway commandGateway;

    @Autowired
    public MovieReviewPublisher(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(value = "/addReview")
    public boolean addMovieReview(@RequestBody Review review) {
        boolean status = (boolean) rabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "addReview", review);
        return status;
    }

    @GetMapping(value = "/getReview/{movieId}")
    public List<Review> getMovieReview(@PathVariable("movieId") String movieId) {
//        MovieReview mr = new MovieReview(movieName, score, review, reviewBy);
        List<Review> reviews = (List<Review>) rabbitTemplate.convertSendAndReceive("MyMovieMoodDirect", "getReview", movieId);
        return reviews;
    }

    @GetMapping(value = "/bla")
    public void bla() {
//        MovieReview mr = new MovieReview(movieName, score, review, reviewBy);
        System.out.println("bla bla");
    }

}
