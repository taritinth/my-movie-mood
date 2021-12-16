package com.sop.chapter7.productservice.command;

import com.sop.chapter9.core.command.CalculateRatingCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private String movieId;
    private Double rating;
    private String review;
    private String reviewBy;
//    private String productId;
//    private String title;
//    private BigDecimal price;
//    private Integer quantity;

    public ProductAggregate(){
    }

//    @CommandHandler
//    public ProductAggregate(CreateProductCommand createProductCommand){
//        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0){
//            throw new IllegalArgumentException("Price cannot be less than or equal to zero");
//        }
//
//        if (createProductCommand.getTitle() == null || createProductCommand.getTitle().isBlank()){
//            throw new IllegalArgumentException("Title cannot be empty");
//        }
//
//        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
//        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
//        AggregateLifecycle.apply(productCreatedEvent);
//    }

//    @CommandHandler
//    public void handler(ReserveProductCommand reserveProductCommand){
//        if (quantity < reserveProductCommand.getQuantity()){
//            throw new IllegalArgumentException("Insufficient number of items in stock");
//        }
//        ProductReservedEvent productReservedEvent = ProductReservedEvent.builder()
//                .orderId(reserveProductCommand.getOrderId())
//                .productId(reserveProductCommand.getProductId())
//                .quantity(reserveProductCommand.getQuantity())
//                .userId(reserveProductCommand.getUserId())
//                .build();
//        AggregateLifecycle.apply(productReservedEvent);
//    }

    @CommandHandler
    public ProductAggregate(CalculateRatingCommand calculateRatingCommand){
        this.id = calculateRatingCommand.getId();
        if (false){
            throw new IllegalArgumentException("Insufficient number of items in stock");
        }
    }

//    @EventSourcingHandler
//    public void on(ProductCreatedEvent productCreatedEvent){
//        this.productId = productCreatedEvent.getProductId();
//        this.title = productCreatedEvent.getTitle();
//        this.price = productCreatedEvent.getPrice();
//        this.quantity = productCreatedEvent.getQuantity();
//    }
//
//    @EventSourcingHandler
//    public void on(ProductReservedEvent productReservedEvent){
//        this.quantity -= productReservedEvent.getQuantity();
//    }
}
