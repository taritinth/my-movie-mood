package com.sop.lab10.movielistservice.services;

import com.sop.lab10.movielistservice.entities.AuthRequest;
import com.sop.lab10.movielistservice.entities.AuthResponse;
import com.sop.lab10.movielistservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieListService {

    public String getMovie(String movieId){
        return movieId;
    }
}
