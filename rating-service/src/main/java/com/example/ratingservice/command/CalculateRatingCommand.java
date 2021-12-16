package com.example.ratingservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CalculateRatingCommand {
    @TargetAggregateIdentifier
    private final String movieId;
    private final double rating;
}
