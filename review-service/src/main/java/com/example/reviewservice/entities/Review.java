package com.example.reviewservice.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Review")
public class Review implements Serializable {
    private String _id;
    private String movieId;
    private double rating;
    private String review;
    private String reviewBy;

//    public Review() {
//        this("", 0.0, "", "");
//    }
//
//    public Review(String movieId, double score, String review, String reviewBy) {
//        this._id = movieId;
//        this.score = score;
//        this.review = review;
//        this.reviewBy = reviewBy;
//    }

}
