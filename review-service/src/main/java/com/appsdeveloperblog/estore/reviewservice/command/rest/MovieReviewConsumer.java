package com.appsdeveloperblog.estore.reviewservice.command.rest;

import com.appsdeveloperblog.estore.reviewservice.command.commands.CreateReviewCommand;
import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;
import com.appsdeveloperblog.estore.reviewservice.core.entities.ReviewPojo;
import com.appsdeveloperblog.estore.reviewservice.core.repository.ReviewRepository2;
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

    @Autowired
    private ReviewRepository2 reviewRepository2;


    @RabbitListener(queues = "AddMovieReviewQueue")
    public boolean addMovieReview(Review review) {
        String uuid = UUID.randomUUID().toString();
        CreateReviewCommand createReviewCommand = CreateReviewCommand.builder()
                .movieId(review.getMovieId())
                .rating(review.getRating())
                .review(review.getReview())
                .reviewBy(review.getReviewBy())
                .reviewTitle(review.getReviewTitle())
                .reviewId(uuid)
                .userEmail(review.getUserEmail())
                .movieVote(reviewService.getMovieById(review.getMovieId()).getVote())
                .movieRating(reviewService.getMovieById(review.getMovieId()).getRating())
                .build();
        review.setReviewId(uuid);
        String result;
        List<ReviewPojo> checkReviewBy = reviewRepository2.findByReview(review.getReviewBy(), review.getMovieId());
        if(checkReviewBy.isEmpty()){
            try{
                result = commandGateway.sendAndWait(createReviewCommand);
                return true;
            } catch (Exception e){
                result = e.getLocalizedMessage();
                return false;
            }
        }else{
            return false;
        }



    }


    @RabbitListener(queues = "GetMovieReviewQueue")
    public List<ReviewPojo> getReviewByMovieId(String movieId){
        return  reviewService.getReviewByMovieId(movieId);
    }



}
