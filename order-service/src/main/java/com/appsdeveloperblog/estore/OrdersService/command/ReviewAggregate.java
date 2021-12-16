/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.OrdersService.command;

import com.appsdeveloperblog.estore.OrdersService.core.events.ReviewCreatedEvent;
import com.appsdeveloperblog.estore.OrdersService.command.commands.CreateReviewCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ReviewAggregate {

//    @AggregateIdentifier
//    private String _Id;
    @AggregateIdentifier
    private String id;
    private String movieId;
    private Double rating;
    private String review;
    private String reviewBy;
    
    public ReviewAggregate() {
    }

    @CommandHandler
    public ReviewAggregate(CreateReviewCommand createReviewCommand) {
        System.out.println("do command la");
        ReviewCreatedEvent reviewCreatedEvent = new ReviewCreatedEvent();
        BeanUtils.copyProperties(createReviewCommand, reviewCreatedEvent);
        
        AggregateLifecycle.apply(reviewCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ReviewCreatedEvent reviewCreatedEvent) throws Exception {
        System.out.println("jer event la");
        this.id = reviewCreatedEvent.getId();
        this.movieId = reviewCreatedEvent.getMovieId();
        this.rating = reviewCreatedEvent.getRating();
        this.review = reviewCreatedEvent.getReview();
        this.reviewBy = reviewCreatedEvent.getReviewBy();
        System.out.println(this.id);
    }
 

}
