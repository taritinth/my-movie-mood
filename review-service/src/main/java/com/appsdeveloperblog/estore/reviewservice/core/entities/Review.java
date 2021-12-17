/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.reviewservice.core.entities;


import javax.persistence.Id;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Review")
public class Review implements Serializable {

    @Id
    private String reviewId;
    private String movieId;
    private Double rating;
    private String reviewTitle;
    private String review;
    private String reviewBy;
    private String userEmail;
    private String timestamp;
}
