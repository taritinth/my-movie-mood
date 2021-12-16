package com.sop.ratingservice.command;

import com.sop.chapter9.core.command.CalculateRatingCommand;
import com.sop.ratingservice.core.event.CalculateRatingBla4Event;
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
    private String review;
    private String reviewBy;

    @Autowired
    private RatingService ratingService;

    public RatingAggregate() {

    }

    @CommandHandler
    public RatingAggregate(CalculateRatingCommand calculateRatingCommand) {
        this.ratingId = UUID.randomUUID().toString();
        System.out.println(calculateRatingCommand+"1");

        CalculateRatingBla4Event ratingEvent = new CalculateRatingBla4Event();
        BeanUtils.copyProperties(calculateRatingCommand, ratingEvent);
        ratingEvent.setRatingId(this.ratingId);
        AggregateLifecycle.apply(ratingEvent);


        System.out.println(ratingId);
        System.out.println("in aggregate");

        if (false) {
            throw new IllegalArgumentException("exception");
        }
    }

    @EventSourcingHandler
    public void on(CalculateRatingBla4Event calculateRatingBla4Event) {
        System.out.println("in event handler");
        this.reviewId = calculateRatingBla4Event.getReviewId();
        this.movieId = calculateRatingBla4Event.getMovieId();
        this.rating = calculateRatingBla4Event.getRating();
        this.review = calculateRatingBla4Event.getReview();
        this.reviewBy = calculateRatingBla4Event.getReviewBy();
    }
}
