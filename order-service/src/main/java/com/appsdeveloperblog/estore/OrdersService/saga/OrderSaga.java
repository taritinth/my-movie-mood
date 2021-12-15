package com.appsdeveloperblog.estore.OrdersService.saga;

import com.appsdeveloperblog.estore.OrdersService.core.events.ReviewCreatedEvent;
import com.sop.chapter9.core.command.CalculateRatingCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class OrderSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    public void handle(ReviewCreatedEvent review){
        CalculateRatingCommand calculateRatingCommand = CalculateRatingCommand.builder()
                .id(review.getId())
                .movieId(review.getMovieId())
                .rating(review.getRating())
                .review(review.getReview())
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
