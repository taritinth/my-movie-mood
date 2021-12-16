/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.reviewservice.core.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreatedEvent2 {
    private String reviewId;
    private String movieId;
    private Double rating;
    private String reviewTitle;
    private String review;
    private String reviewBy;
    private Double movieRating;
    private int movieVote;
    private String userEmail;
}
