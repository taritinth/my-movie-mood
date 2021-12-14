package com.example.reviewservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MovieReviewConsumer {

    @RabbitListener(queues = "MovieReviewQueue")
    public void getMovieReview(MovieReview mr) {
        System.out.println("Movie : "+mr.getMovieName());
        System.out.println("Score : "+mr.getScore());
        System.out.println("Review : "+mr.getReview());
        System.out.println("Review By : "+mr.getReviewBy());

    }

}