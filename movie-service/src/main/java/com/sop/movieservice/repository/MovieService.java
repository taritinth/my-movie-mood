package com.sop.movieservice.repository;

import com.sop.movieservice.entities.Movie;
import com.sop.movieservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    @Autowired
    private UserRepository repository2;

    public List<Movie> getAllMovies() {
        try {
            List<User> userObj = repository2.findAll();
            System.out.println(userObj);

            return repository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

}
