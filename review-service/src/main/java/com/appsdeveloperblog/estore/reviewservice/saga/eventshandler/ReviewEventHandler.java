package com.appsdeveloperblog.estore.reviewservice.saga.eventshandler;


import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;
import com.appsdeveloperblog.estore.reviewservice.core.events.ReviewCreatedEvent2;
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
    public void on(ReviewCreatedEvent2 reviewCreatedEvent2){
        Review review = new Review();
        BeanUtils.copyProperties(reviewCreatedEvent2, review);
        reviewService.addReview(review);
    }
}
