package com.sop.movieservice.repository;

import com.sop.movieservice.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    @Query(value = "{name : {$regex : '?0'}")
    public List<Movie> findByName(String name);
}
