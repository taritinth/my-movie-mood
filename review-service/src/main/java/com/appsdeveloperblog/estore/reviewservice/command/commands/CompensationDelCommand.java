package com.appsdeveloperblog.estore.reviewservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CompensationDelCommand {
    @TargetAggregateIdentifier
    private final String reviewId;
    private final String movieId;
    private final Double rating;
    private final String reviewTitle;
    private final String review;
    private final String reviewBy;
    private final Double movieRating;
    private final int movieVote;
    private final String userEmail;
}
