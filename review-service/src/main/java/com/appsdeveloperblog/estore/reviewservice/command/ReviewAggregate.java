/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.reviewservice.command;

import com.appsdeveloperblog.estore.reviewservice.core.events.ReviewCreatedEvent2;
import com.appsdeveloperblog.estore.reviewservice.command.commands.CreateReviewCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ReviewAggregate {

    @AggregateIdentifier
    private String reviewId;
    private String movieId;
    private Double rating;
    private String review;
    private String reviewTitle;
    private String reviewBy;
    private Double movieRating;
    private int movieVote;
    private String userEmail;
    
    public ReviewAggregate() {
    }

    @CommandHandler
    public ReviewAggregate(CreateReviewCommand createReviewCommand) {
        ReviewCreatedEvent2 reviewCreatedEvent2 = new ReviewCreatedEvent2();
        BeanUtils.copyProperties(createReviewCommand, reviewCreatedEvent2);
        AggregateLifecycle.apply(reviewCreatedEvent2);
    }



    @EventSourcingHandler
    public void on(ReviewCreatedEvent2 reviewCreatedEvent2) throws Exception {
        this.reviewId = reviewCreatedEvent2.getReviewId();
        this.movieId = reviewCreatedEvent2.getMovieId();
        this.rating = reviewCreatedEvent2.getRating();
        this.reviewTitle = reviewCreatedEvent2.getReviewTitle();
        this.review = reviewCreatedEvent2.getReview();
        this.reviewBy = reviewCreatedEvent2.getReviewBy();
        this.movieVote = reviewCreatedEvent2.getMovieVote();
        this.movieRating = reviewCreatedEvent2.getMovieRating();
        this.userEmail = reviewCreatedEvent2.getUserEmail();

        System.out.println(this.reviewId);
    }
 

}
