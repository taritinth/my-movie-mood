/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.OrdersService.core.POJO;

import com.appsdeveloperblog.estore.OrdersService.core.model.OrderStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Review")
public class Review implements Serializable {

    @Id
    private  String _id;
    private String movieId;
    private Double rating;
    private String review;
    private String reviewBy;

}
