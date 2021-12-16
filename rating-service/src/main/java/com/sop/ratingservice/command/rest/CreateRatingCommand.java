package com.sop.ratingservice.command.rest;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateRatingCommand {

    @TargetAggregateIdentifier
    private final String ratingId;
    private final String reviewId;
    private final String movieId;
    private final Double rating;
    private final String review;
    private final String reviewBy;
    private final Double movieRating;
    private final int movieVote;
}
