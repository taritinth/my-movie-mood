package com.sop.ratingservice.query;

import com.sop.ratingservice.core.event.CalculateRatingEvent;
import com.sop.ratingservice.core.event.DecreaseRatingEvent;
import com.sop.ratingservice.core.repository.RatingService;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RatingEventsHandler {

    @Autowired
    private RatingService ratingService;

    public RatingEventsHandler(RatingService ratingService){
        this.ratingService = ratingService;
    }

    @EventHandler
    public void on(CalculateRatingEvent calculateRatingEvent){
        Boolean movieStatus = ratingService.updateRating(calculateRatingEvent.getMovieId(), calculateRatingEvent.getRating(), calculateRatingEvent.getMovieRating(), calculateRatingEvent.getMovieVote());
    }

    @EventHandler
    public void on(DecreaseRatingEvent decreaseRatingEvent){
        Boolean movieStatus = ratingService.decreaseRating(decreaseRatingEvent.getMovieId(), decreaseRatingEvent.getRating(), decreaseRatingEvent.getMovieRating(), decreaseRatingEvent.getMovieVote());
    }
}
