package com.sop.ratingservice.query;

import com.sop.ratingservice.core.event.CalculateRatingBla4Event;
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
    public void on(CalculateRatingBla4Event calculateRatingBla4Event){

        Boolean movieStatus = ratingService.updateRating(calculateRatingBla4Event.getMovieId(), calculateRatingBla4Event.getRating(), calculateRatingBla4Event.getMovieRating(), calculateRatingBla4Event.getMovieVote());
        System.out.println(movieStatus);
        System.out.println(ratingService.getMovieById("61bb16d8553c2d4fcd4c55ca"));
        System.out.println(calculateRatingBla4Event);
    }
}
