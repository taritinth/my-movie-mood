package com.appsdeveloperblog.estore.reviewservice.core.repository;

import com.appsdeveloperblog.estore.reviewservice.core.entities.Movie;
import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;
import com.appsdeveloperblog.estore.reviewservice.core.entities.ReviewPojo;
import com.appsdeveloperblog.estore.reviewservice.core.events.MovieRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ReviewRepository2 reviewRepository2;

    @Autowired
    private MovieRepository movieRepository;

    public List<ReviewPojo> getReviewByMovieId(String movieId) {
        try {
            return reviewRepository2.findByMovieId(movieId);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteReviewById(Review review) {
        try {
            ReviewPojo checkReviewBy = reviewRepository2.findByReviewId(review.getReviewId());
            reviewRepository2.delete(checkReviewBy);
            System.out.println("del complete");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean addReview(Review review) {
        try {
            ReviewPojo checkReviewId = reviewRepository2.findByReviewId(review.getReviewId());
            if(checkReviewId == null){
                List<ReviewPojo> checkReviewBy = reviewRepository2.findByReview(review.getReviewBy(), review.getMovieId());
                if(checkReviewBy.isEmpty()){
                    review.setTimestamp(new Timestamp(System.currentTimeMillis()).toString());
                    repository.save(review);
                    return false;
                }else{
                    System.out.println("รีวิวซ้ำคน");
                    return false;
                }
            }else{
                System.out.println("รีวิวซ้ำจาก event");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public Movie getMovieById(String movieId){
        try {
            Movie movie = movieRepository.findByMovieId(movieId);
            return movie;
        } catch (Exception e) {
            return null;
        }
    }
}
