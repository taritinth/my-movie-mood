package com.appsdeveloperblog.estore.OrdersService.command.rest;

import com.appsdeveloperblog.estore.OrdersService.command.commands.CreateReviewCommand;
import com.appsdeveloperblog.estore.OrdersService.core.POJO.Review;
import com.appsdeveloperblog.estore.OrdersService.core.Repository.ReviewService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component
public class MovieReviewConsumer {


    private final CommandGateway commandGateway;
    @Autowired
    public MovieReviewConsumer(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Autowired
    ReviewService reviewService;

    @RabbitListener(queues = "AddMovieReviewQueue")
    public boolean addMovieReview(Review review) {
        System.out.println(review.getReview());
        CreateReviewCommand createReviewCommand = CreateReviewCommand.builder()
                .movieId(review.getMovieId())
                .rating(review.getRating())
                .review(review.getReview())
                .reviewBy(review.getReviewBy())
                .id(UUID.randomUUID().toString())
                .build();

        commandGateway.send(createReviewCommand);

        return reviewService.addReview(review);
    }


    @RabbitListener(queues = "GetMovieReviewQueue")
    public List<Review> getReviewByMovieId(String movieId){
        System.out.println(movieId);
        return reviewService.getReviewByMovieId(movieId);
    }



}
