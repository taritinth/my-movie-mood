package com.sop.chapter9.core.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DecreaseRatingCommand {
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
    private final String movieName;
}
