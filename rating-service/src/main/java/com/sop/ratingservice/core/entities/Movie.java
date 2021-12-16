package com.sop.ratingservice.core.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Data
@Document("Movie")
public class Movie {

    @Id
    private String _id;
    private String name;
    private Double rating;
    private int vote;
    private String poster;
    private Double imdbRating;
    private String imdbId;
    private int year;

}
