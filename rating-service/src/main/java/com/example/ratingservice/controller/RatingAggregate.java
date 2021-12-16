package com.example.ratingservice.controller;

import com.example.ratingservice.command.CalculateRatingCommand;
import org.axonframework.commandhandling.CommandHandler;

public class RatingAggregate {

    @CommandHandler
    public RatingAggregate(CalculateRatingCommand calculateRatingCommand){
        System.out.println("command");
    }
}
