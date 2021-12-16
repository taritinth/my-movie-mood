package com.example.reviewservice.repository;

import com.example.reviewservice.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    @Query(value = "{movieId:'?0'}")
    public List<Review> findByMovieId(String movieId);
}
