package com.appsdeveloperblog.estore.OrdersService.command.commands;


import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CalculateRatingCommand {

//    @TargetAggregateIdentifier
//    public final String _Id;
    @TargetAggregateIdentifier
    private final String id;
    private final String movieId;
    private final Double rating;
    private final String review;
    private final String reviewBy;
}
