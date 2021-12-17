package com.appsdeveloperblog.estore.reviewservice.saga;

import com.appsdeveloperblog.estore.reviewservice.command.commands.CompensationAddCommand;
import com.appsdeveloperblog.estore.reviewservice.command.commands.CompensationDelCommand;
import com.appsdeveloperblog.estore.reviewservice.core.events.ReviewCreatedEvent;
import com.appsdeveloperblog.estore.reviewservice.core.events.ReviewDeletedEvent;
import com.sop.chapter9.core.command.CalculateRatingCommand;
import com.sop.chapter9.core.command.DecreaseRatingCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class ReviewSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "reviewId")
    public void handle(ReviewCreatedEvent review){
        CalculateRatingCommand calculateRatingCommand = CalculateRatingCommand.builder()
                .reviewId(review.getReviewId())
                .movieId(review.getMovieId())
                .rating(review.getRating())
                .reviewTitle(review.getReviewTitle())
                .review(review.getReview())
                .movieVote(review.getMovieVote())
                .movieRating(review.getMovieRating())
                .reviewBy(review.getReviewBy())
                .userEmail(review.getUserEmail())
                .build();
        commandGateway.send(calculateRatingCommand, (commandMessage, commandResultMessage) -> {
            System.out.println("this is a commmand " + commandResultMessage);
            if (commandResultMessage.isExceptional()) {
                System.out.println("exception here");
                // Start compensating transaction
                CompensationDelCommand compensationDelCommand = CompensationDelCommand.builder()
                        .reviewId(review.getReviewId())
                        .movieId(review.getMovieId())
                        .rating(review.getRating())
                        .reviewTitle(review.getReviewTitle())
                        .review(review.getReview())
                        .movieVote(review.getMovieVote())
                        .movieRating(review.getMovieRating())
                        .reviewBy(review.getReviewBy())
                        .userEmail(review.getUserEmail())
                        .build();
                String result;
                try{
                    result = commandGateway.sendAndWait(compensationDelCommand);
                    System.out.println("send del command");
                } catch (Exception e){
                    result = e.getLocalizedMessage();
                }

            }
        });
    }

    @StartSaga
    @SagaEventHandler(associationProperty = "reviewId")
    public void handle(ReviewDeletedEvent review){
        System.out.println("Tum");
        DecreaseRatingCommand decreaseRatingCommand = DecreaseRatingCommand.builder()
                .reviewId(review.getReviewId())
                .movieId(review.getMovieId())
                .rating(review.getRating())
                .reviewTitle(review.getReviewTitle())
                .review(review.getReview())
                .movieVote(review.getMovieVote())
                .movieRating(review.getMovieRating())
                .reviewBy(review.getReviewBy())
                .userEmail(review.getUserEmail())
                .build();
        commandGateway.send(decreaseRatingCommand, (commandMessage, commandResultMessage) -> {
            System.out.println("this is a commmand " + commandResultMessage);
            if (commandResultMessage.isExceptional()) {
                System.out.println("exception here");
                // Start compensating transaction
                CompensationAddCommand compensationAddCommand = CompensationAddCommand.builder()
                        .reviewId(review.getReviewId())
                        .movieId(review.getMovieId())
                        .rating(review.getRating())
                        .reviewTitle(review.getReviewTitle())
                        .review(review.getReview())
                        .movieVote(review.getMovieVote())
                        .movieRating(review.getMovieRating())
                        .reviewBy(review.getReviewBy())
                        .userEmail(review.getUserEmail())
                        .build();
                String result;
                try{
                    result = commandGateway.sendAndWait(compensationAddCommand);
                    System.out.println("send add command");
                } catch (Exception e){
                    result = e.getLocalizedMessage();
                }

            }
        });
    }
}
