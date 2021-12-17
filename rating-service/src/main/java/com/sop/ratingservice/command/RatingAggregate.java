package com.sop.ratingservice.command;

import com.sop.chapter9.core.command.CalculateRatingCommand;
import com.sop.chapter9.core.command.DecreaseRatingCommand;
import com.sop.ratingservice.core.event.CalculateRatingEvent;
import com.sop.ratingservice.core.event.DecreaseRatingEvent;
import com.sop.ratingservice.core.repository.RatingService;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;


@Aggregate
public class RatingAggregate {

    @AggregateIdentifier
    private String ratingId;
    private String reviewId;
    private String movieId;
    private Double rating;
    private String reviewTitle;
    private String review;
    private String reviewBy;
    private Double movieRating;
    private int movieVote;
    private String userEmail;

    @Autowired
    private RatingService ratingService;

    public RatingAggregate() {

    }

    @CommandHandler
    public RatingAggregate(CalculateRatingCommand calculateRatingCommand) {
        this.ratingId = UUID.randomUUID().toString();
        System.out.println(calculateRatingCommand+"1");

        CalculateRatingEvent ratingEvent = new CalculateRatingEvent();
        BeanUtils.copyProperties(calculateRatingCommand, ratingEvent);
        ratingEvent.setRatingId(this.ratingId);
        AggregateLifecycle.apply(ratingEvent);


        System.out.println(ratingId);
        System.out.println("in aggregate");

        if (false) {
            throw new IllegalArgumentException("exception");
        }
    }

    @CommandHandler
    public RatingAggregate(DecreaseRatingCommand decreaseRatingCommand) {
        this.ratingId = UUID.randomUUID().toString();
        System.out.println(decreaseRatingCommand+"1");

        DecreaseRatingEvent decreaseRatingEvent = new DecreaseRatingEvent();
        BeanUtils.copyProperties(decreaseRatingCommand, decreaseRatingEvent);
        decreaseRatingEvent.setRatingId(this.ratingId);
        AggregateLifecycle.apply(decreaseRatingEvent);


        System.out.println(ratingId);
        System.out.println("in aggregate");

        if (false) {
            throw new IllegalArgumentException("exception");
        }
    }

    @EventSourcingHandler
    public void on(CalculateRatingEvent calculateRatingEvent) {
        System.out.println("in event handler");
        this.reviewId = calculateRatingEvent.getReviewId();
        this.movieId = calculateRatingEvent.getMovieId();
        this.rating = calculateRatingEvent.getRating();
        this.reviewTitle = calculateRatingEvent.getReviewTitle();
        this.review = calculateRatingEvent.getReview();
        this.reviewBy = calculateRatingEvent.getReviewBy();
        this.movieRating = calculateRatingEvent.getMovieRating();
        this.movieVote = calculateRatingEvent.getMovieVote();
        this.userEmail = calculateRatingEvent.getUserEmail();
    }
}
