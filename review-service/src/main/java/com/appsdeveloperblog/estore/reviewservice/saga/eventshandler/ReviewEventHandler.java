package com.appsdeveloperblog.estore.reviewservice.saga.eventshandler;


import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;
import com.appsdeveloperblog.estore.reviewservice.core.events.CompensationAddEvent;
import com.appsdeveloperblog.estore.reviewservice.core.events.ReviewCreatedEvent;
import com.appsdeveloperblog.estore.reviewservice.core.events.CompensationDelEvent;
import com.appsdeveloperblog.estore.reviewservice.core.events.ReviewDeletedEvent;
import com.appsdeveloperblog.estore.reviewservice.core.repository.ReviewService;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewEventHandler {


    @Autowired
    private ReviewService reviewService;

    @EventHandler
    public void on(ReviewCreatedEvent reviewCreatedEvent){
        Review review = new Review();
        BeanUtils.copyProperties(reviewCreatedEvent, review);
        reviewService.addReview(review);
    }

    @EventHandler
    public void on(CompensationDelEvent compensationDelEvent){
        Review review = new Review();
        BeanUtils.copyProperties(compensationDelEvent, review);
        reviewService.deleteReviewById(review);
    }

    @EventHandler
    public void on(CompensationAddEvent compensationAddEvent){
        Review review = new Review();
        BeanUtils.copyProperties(compensationAddEvent, review);
        reviewService.addReview(review);
    }

    @EventHandler
    public void on(ReviewDeletedEvent reviewDeletedEvent){
        System.out.println("kao handler");
        Review review = new Review();
        BeanUtils.copyProperties(reviewDeletedEvent, review);
        reviewService.deleteReviewById(review);
    }
}
