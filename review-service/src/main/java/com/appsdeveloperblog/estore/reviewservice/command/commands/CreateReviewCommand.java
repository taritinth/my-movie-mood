/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.reviewservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateReviewCommand {
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
