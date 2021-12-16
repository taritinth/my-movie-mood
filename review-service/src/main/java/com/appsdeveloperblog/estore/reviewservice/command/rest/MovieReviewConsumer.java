package com.appsdeveloperblog.estore.reviewservice.command.rest;

import com.appsdeveloperblog.estore.reviewservice.command.commands.CreateReviewCommand;
import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;
import com.appsdeveloperblog.estore.reviewservice.core.entities.ReviewPojo;
import com.appsdeveloperblog.estore.reviewservice.core.repository.ReviewService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private ReviewService reviewService;

    @RabbitListener(queues = "AddMovieReviewQueue")
    public boolean addMovieReview(Review review) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(review.getReview());
        CreateReviewCommand createReviewCommand = CreateReviewCommand.builder()
                .movieId(review.getMovieId())
                .rating(review.getRating())
                .review(review.getReview())
                .reviewBy(review.getReviewBy())
                .reviewTitle(review.getReviewTitle())
                .reviewId(uuid)
                .movieVote(reviewService.getMovieById(review.getMovieId()).getVote())
                .movieRating(reviewService.getMovieById(review.getMovieId()).getRating())
                .build();
        review.setReviewId(uuid);
        System.out.println(reviewService.getReviewByMovieId(review.getMovieId())+"1");
        String result;
        try{
            result = commandGateway.sendAndWait(createReviewCommand);
            return true;
        } catch (Exception e){
            result = e.getLocalizedMessage();
            return false;
        }

    }


    @RabbitListener(queues = "GetMovieReviewQueue")
    public List<ReviewPojo> getReviewByMovieId(String movieId){
        System.out.println(movieId);
        return  reviewService.getReviewByMovieId(movieId);
    }



}
