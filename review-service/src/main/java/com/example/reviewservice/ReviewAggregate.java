///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.example.reviewservice;
//
//import com.appsdeveloperblog.estore.OrdersService.command.commands.CreateOrderCommand;
//import com.appsdeveloperblog.estore.OrdersService.core.events.OrderCreatedEvent;
//import com.appsdeveloperblog.estore.OrdersService.core.model.OrderStatus;
//import com.example.reviewservice.command.CalculateRatingCommand;
//import com.example.reviewservice.event.CalculateRatingEvent;
//import org.axonframework.commandhandling.CommandHandler;
//import org.axonframework.eventsourcing.EventSourcingHandler;
//import org.axonframework.modelling.command.AggregateIdentifier;
//import org.axonframework.modelling.command.AggregateLifecycle;
//import org.axonframework.spring.stereotype.Aggregate;
//import org.springframework.beans.BeanUtils;
//
//@Aggregate
//public class ReviewAggregate {
//
//    @AggregateIdentifier
//    private String movieId;
//    private double rating;
//
//    public ReviewAggregate() {
//    }
//
//    @CommandHandler
//    public ReviewAggregate(CalculateRatingCommand calculateRatingCommand) {
//        CalculateRatingEvent calculateRatingEvent = new CalculateRatingEvent();
//        BeanUtils.copyProperties(CalculateRatingCommand, CalculateRatingEvent);
//
//        AggregateLifecycle.apply(CalculateRatingEvent);
//    }
//
//    @EventSourcingHandler
//    public void on(CalculateRatingEvent calculateRatingEvent) throws Exception {
//        this.movieId = calculateRatingEvent.getMovieId();
//        this.rating = calculateRatingEvent.getRating();
//    }
//
//
//}
