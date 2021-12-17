package com.appsdeveloperblog.estore.reviewservice.core.repository;

import com.appsdeveloperblog.estore.reviewservice.core.entities.ReviewQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepositoryQuery extends MongoRepository<ReviewQuery, String> {

    @Query(value = "{movieId:'?0'}")
    public List<ReviewQuery> findByMovieId(String movieId);

    @Query(value = "{reviewId:'?0'}")
    public ReviewQuery findByReviewId(String reviewId);

    @Query(value = "{reviewBy:'?0', movieId:'?1'}")
    public List<ReviewQuery> findByReview(String reviewBy, String movieId);


}
