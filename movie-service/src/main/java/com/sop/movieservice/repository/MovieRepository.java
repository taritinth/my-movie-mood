package com.sop.movieservice.repository;

import com.sop.movieservice.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
//
//    @Query(value = "{name:'?0'}")
//    public Product findByName(String name);
}
