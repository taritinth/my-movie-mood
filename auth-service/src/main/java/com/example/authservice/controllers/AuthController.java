package com.example.authservice.controllers;

import com.example.authservice.entities.AuthRequest;
import com.example.authservice.entities.AuthResponse;
import com.example.authservice.entities.User;
import com.example.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    //    @Autowired
//    public AuthController(final AuthService authService) {
//        this.authService = authService;
//    }
    @PostMapping(value = "/signup")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        return ResponseEntity.ok(authService.signUp(user)) ;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> signIn(@RequestBody AuthRequest authRequest) {
        AuthResponse res = authService.signIn(authRequest);
        return res != null ? ResponseEntity.ok(res) : new ResponseEntity<>("INVALID AUTHENTICATION", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/me")
    public ResponseEntity<?> me(@RequestHeader(value = "Authorization") String token, @RequestHeader(value = "id") String id, @RequestHeader(value = "email") String email, @RequestHeader(value = "role") String role) {
        System.out.println("Authorization : " + token);
        return ResponseEntity.ok(authService.me(id, email, role));
    }

}
