package com.example.reviewservice;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieReview implements Serializable {
    private String movieName;
    private double score;
    private String review;
    private String reviewBy;

    public MovieReview() {
        this("", 0.0, "", "");
    }

    public MovieReview(String movieName, double score, String review, String reviewBy) {
        this.movieName = movieName;
        this.score = score;
        this.review = review;
        this.reviewBy = reviewBy;
    }

}
