///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.appsdeveloperblog.estore.OrdersService.query;
//
//import com.appsdeveloperblog.estore.OrdersService.core.POJO.Review;
//import com.appsdeveloperblog.estore.OrdersService.core.Repository.ReviewRepository;
//import com.appsdeveloperblog.estore.OrdersService.core.events.ReviewCreatedEvent;
//import org.axonframework.config.ProcessingGroup;
//import org.axonframework.eventhandling.EventHandler;
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Component;
//
//@Component
//@ProcessingGroup("order-group")
//public class OrderEventsHandler {
//
//    private final ReviewRepository reviewRepository;
//
//    public OrderEventsHandler(ReviewRepository reviewRepository) {
//        this.reviewRepository = reviewRepository;
//    }
//
//    @EventHandler
//    public void on(ReviewCreatedEvent event) throws Exception {
////        Review review = new Review();
////        BeanUtils.copyProperties(event, review);
////
////        this.reviewRepository.save(review);
//        System.out.println("Review Create Event DO");
//    }
//
//}
