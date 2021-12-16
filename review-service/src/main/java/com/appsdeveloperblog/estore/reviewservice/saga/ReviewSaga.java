package com.appsdeveloperblog.estore.reviewservice.saga;

import com.appsdeveloperblog.estore.reviewservice.core.events.ReviewCreatedEvent2;
import com.sop.chapter9.core.command.CalculateRatingCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
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
    @EndSaga
    public void handle(ReviewCreatedEvent2 review){
        CalculateRatingCommand calculateRatingCommand = CalculateRatingCommand.builder()
                .reviewId(review.getReviewId())
                .movieId(review.getMovieId())
                .rating(review.getRating())
                .review(review.getReview())
                .movieVote(review.getMovieVote())
                .movieRating(review.getMovieRating())
                .reviewBy(review.getReviewBy())
                .build();
        commandGateway.send(calculateRatingCommand, (commandMessage, commandResultMessage) -> {
            System.out.println("this is sout commmand " + commandResultMessage);
            if (commandResultMessage.isExceptional()) {
                System.out.println("tum nai exception");
                // Start compensating transaction
            }
        });
    }
}
