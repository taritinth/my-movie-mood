package com.example.authservice.services;

import com.example.authservice.entities.*;
import com.example.authservice.repository.AuthRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtUtil jwt;

    @Autowired
    private AuthRepository repository;

    @Autowired
    public AuthService(final JwtUtil jwt) {
        this.jwt = jwt;
    }

    public AuthResponse logIn(AuthRequest authRequest) {
        try {
            //check email and password here
            User userObj = repository.findUser(authRequest.getEmail());

//            String candidate = BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt());
//            System.out.println("candidate:" + candidate);
//
//            System.out.println("hased:"+userObj.getPassword());

            if (userObj != null) {
                if (BCrypt.checkpw(authRequest.getPassword(), userObj.getPassword())) {
                    User user = User.builder()
                            ._id(userObj.get_id())
                            .email(userObj.getEmail())
                            .role(userObj.getRole())
                            .build();
                    String accessToken = jwt.generate(user, "ACCESS");
                    String refreshToken = jwt.generate(user, "REFRESH");

                    return new AuthResponse(accessToken, refreshToken);
                } else
                    System.out.println("It does not match");
                    return null;

            } else {
                System.out.println("Not found user");
                return null;
            }

        } catch (Exception e) {
            System.out.println("Exception e");
            return null;
        }

    }

    public AuthMeResponse me(String id, String email, String role) {
        return new AuthMeResponse(id, email, role);
    }

}
