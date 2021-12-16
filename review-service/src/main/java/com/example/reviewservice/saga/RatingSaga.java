package com.example.reviewservice.saga;

import com.example.reviewservice.command.CalculateRatingCommand;
import com.example.reviewservice.event.CalculateRatingEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class RatingSaga {
    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "movieId")
    public void handle(CalculateRatingEvent calculateRatingEvent) {
        CalculateRatingCommand calculateRatingCommand = CalculateRatingCommand.builder()
                .movieId(calculateRatingEvent.getMovieId())
                .rating(calculateRatingEvent.getRating())
                .build();
        commandGateway.send(calculateRatingCommand, (commandMessage, commandResultMessage) -> {
            if (commandResultMessage.isExceptional()) {
                // Start compensating transaction
            }
        });
    }
}
