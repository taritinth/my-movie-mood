package com.sop.movieservice.repository;

import com.sop.movieservice.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    @Query(value = "{name:{$regex:'?0', $options:'i'}}")
    public List<Movie> findByMovieName(String name);

    @Query(value = "{_id:'?0'}")
    public Movie findByMovieId(String id);
}
