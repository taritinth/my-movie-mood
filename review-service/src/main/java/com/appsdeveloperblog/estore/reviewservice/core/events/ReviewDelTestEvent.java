package com.appsdeveloperblog.estore.reviewservice.core.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDelTestEvent {
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
