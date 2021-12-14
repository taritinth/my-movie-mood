package com.sop.movieservice.repository;

import com.sop.movieservice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    //
    @Query(value = "{email:'?0'}")
    public User findUser(String email);
}
