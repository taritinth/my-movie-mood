package com.appsdeveloperblog.estore.reviewservice.core.repository;

import com.appsdeveloperblog.estore.reviewservice.core.entities.Movie;
import com.appsdeveloperblog.estore.reviewservice.core.entities.Review;
import com.appsdeveloperblog.estore.reviewservice.core.entities.ReviewQuery;
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
    private ReviewRepositoryQuery reviewRepositoryQuery;

    @Autowired
    private MovieRepository movieRepository;

    public List<ReviewQuery> getReviewByMovieId(String movieId) {
        try {
            return reviewRepositoryQuery.findByMovieId(movieId);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteReviewById(Review review) {
        try {
            ReviewQuery checkReviewBy = reviewRepositoryQuery.findByReviewId(review.getReviewId());
            reviewRepositoryQuery.delete(checkReviewBy);
            System.out.println("del complete");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean addReview(Review review) {
        try {
            ReviewQuery checkReviewId = reviewRepositoryQuery.findByReviewId(review.getReviewId());
            if(checkReviewId == null){
                List<ReviewQuery> checkReviewBy = reviewRepositoryQuery.findByReview(review.getReviewBy(), review.getMovieId());
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

    public List<ReviewQuery> getAllReviews(){
        try {
            List<ReviewQuery> review = reviewRepositoryQuery.findAll();
            return review;
        } catch (Exception e) {
            return null;
        }
    }
}
