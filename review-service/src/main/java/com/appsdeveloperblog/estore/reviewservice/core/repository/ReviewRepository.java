/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.reviewservice.core.repository;

import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    @Query(value = "{movieId:'?0'}")
    public List<Review> findByMovieId(String movieId);

    @Query(value = "{reviewId:'?0'}")
    public Review findByReviewId(String reviewId);

    @Query(value = "{reviewBy:'?0', MovieId:'?1'}")
    public Review findByReviewBy(String reviewId, String movieId);

}
