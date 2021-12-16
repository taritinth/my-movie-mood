/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.OrdersService.command.commands;

import com.appsdeveloperblog.estore.OrdersService.core.model.OrderStatus;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateReviewCommand {
        
//    @TargetAggregateIdentifier
//    public final String _Id;
    @TargetAggregateIdentifier
    private final String id;
    private final String movieId;
    private final Double rating;
    private final String review;
    private final String reviewBy;
}
