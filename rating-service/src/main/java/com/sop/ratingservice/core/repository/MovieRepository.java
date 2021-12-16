package com.sop.ratingservice.core.repository;


import com.sop.ratingservice.core.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    @Query(value = "{_id:'?0'}")
    public Movie findByMovieId(String movieId);
}
