package com.appsdeveloperblog.estore.reviewservice.core.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Document("Review")
public class ReviewQuery implements Serializable {

    @Id
    private String _id;
    private String reviewId;
    private String movieId;
    private Double rating;
    private String reviewTitle;
    private String review;
    private String reviewBy;
    private String userEmail;
    private String movieName;
    private String timestamp;
}
