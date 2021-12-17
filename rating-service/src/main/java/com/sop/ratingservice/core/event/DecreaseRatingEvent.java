package com.sop.ratingservice.core.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecreaseRatingEvent {
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
    private String movieName;
}
