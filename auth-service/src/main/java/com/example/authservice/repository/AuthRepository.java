package com.example.authservice.repository;

import com.example.authservice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends MongoRepository<User, String> {
    //
    @Query(value = "{email:'?0',password:'?1'}")
    public User findUser(String email,String password);
}
