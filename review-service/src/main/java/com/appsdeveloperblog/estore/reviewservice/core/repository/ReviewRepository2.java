package com.appsdeveloperblog.estore.reviewservice.core.repository;

import com.appsdeveloperblog.estore.reviewservice.core.entities.Movie;
import com.appsdeveloperblog.estore.reviewservice.core.entities.ReviewPojo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository2 extends MongoRepository<ReviewPojo, String> {

    @Query(value = "{movieId:'?0'}")
    public List<ReviewPojo> findByMovieId(String movieId);
}
