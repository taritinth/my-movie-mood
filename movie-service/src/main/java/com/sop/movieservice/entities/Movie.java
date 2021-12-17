package com.sop.movieservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document("Movie")
public class Movie {
    private String _id;
    private String name;
    private Double rating;
    private int year;
    private int vote;
    private String poster;
    private String imdbId;
    private Double imdbRating;
    private String plot;
    private String actors;
    private String youtubeId;
}
