/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.reviewservice.command;

import com.appsdeveloperblog.estore.reviewservice.command.commands.CompensationAddCommand;
import com.appsdeveloperblog.estore.reviewservice.command.commands.CompensationDelCommand;
import com.appsdeveloperblog.estore.reviewservice.command.commands.DeleteReviewCommand;
import com.appsdeveloperblog.estore.reviewservice.core.events.CompensationAddEvent;
import com.appsdeveloperblog.estore.reviewservice.core.events.ReviewCreatedEvent;
import com.appsdeveloperblog.estore.reviewservice.command.commands.CreateReviewCommand;
import com.appsdeveloperblog.estore.reviewservice.core.events.CompensationDelEvent;
import com.appsdeveloperblog.estore.reviewservice.core.events.ReviewDeletedEvent;
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
        ReviewCreatedEvent reviewCreatedEvent = new ReviewCreatedEvent();
        BeanUtils.copyProperties(createReviewCommand, reviewCreatedEvent);
        AggregateLifecycle.apply(reviewCreatedEvent);
    }

    @CommandHandler
    public void on(CompensationDelCommand compensationDelCommand) {
        CompensationDelEvent compensationDelEvent = new CompensationDelEvent();
        BeanUtils.copyProperties(compensationDelCommand, compensationDelEvent);
        AggregateLifecycle.apply(compensationDelEvent);
    }

    @CommandHandler
    public void on(CompensationAddCommand compensationAddCommand) {
        CompensationAddEvent compensationAddEvent = new CompensationAddEvent();
        BeanUtils.copyProperties(compensationAddCommand, compensationAddEvent);
        AggregateLifecycle.apply(compensationAddEvent);
    }

    @CommandHandler
    public void on(DeleteReviewCommand deleteReviewCommand) {
        System.out.println("Kao aggregate");
        ReviewDeletedEvent reviewDeletedEvent = new ReviewDeletedEvent();
        BeanUtils.copyProperties(deleteReviewCommand, reviewDeletedEvent);
        AggregateLifecycle.apply(reviewDeletedEvent);
    }

    @EventSourcingHandler
    public void on(ReviewDeletedEvent reviewDeletedEvent) throws Exception {
        this.reviewId = reviewDeletedEvent.getReviewId();
        this.movieId = reviewDeletedEvent.getMovieId();
        this.rating = reviewDeletedEvent.getRating();
        this.reviewTitle = reviewDeletedEvent.getReviewTitle();
        this.review = reviewDeletedEvent.getReview();
        this.reviewBy = reviewDeletedEvent.getReviewBy();
        this.movieVote = reviewDeletedEvent.getMovieVote();
        this.movieRating = reviewDeletedEvent.getMovieRating();
        this.userEmail = reviewDeletedEvent.getUserEmail();

        System.out.println(this.reviewId);
    }

    @EventSourcingHandler
    public void on(ReviewCreatedEvent reviewCreatedEvent) throws Exception {
        this.reviewId = reviewCreatedEvent.getReviewId();
        this.movieId = reviewCreatedEvent.getMovieId();
        this.rating = reviewCreatedEvent.getRating();
        this.reviewTitle = reviewCreatedEvent.getReviewTitle();
        this.review = reviewCreatedEvent.getReview();
        this.reviewBy = reviewCreatedEvent.getReviewBy();
        this.movieVote = reviewCreatedEvent.getMovieVote();
        this.movieRating = reviewCreatedEvent.getMovieRating();
        this.userEmail = reviewCreatedEvent.getUserEmail();

        System.out.println(this.reviewId);
    }
 

}
