/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sop.ratingservice.core.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculateRatingEvent {
//    private String _Id;
    private String ratingId;
    private String reviewId;
    private String movieId;
    private String reviewTitle;
    private Double rating;
    private String review;
    private String reviewBy;
    private Double movieRating;
    private int movieVote;
    private String userEmail;
}
