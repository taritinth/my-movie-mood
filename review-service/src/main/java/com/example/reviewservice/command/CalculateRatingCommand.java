package com.example.reviewservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CalculateRatingCommand {
    @TargetAggregateIdentifier
    private final String movieId;
    private final double rating;
}
