package com.sop.lab10.authservice.controllers;

import com.sop.lab10.authservice.entities.AuthMeResponse;
import com.sop.lab10.authservice.entities.AuthRequest;
import com.sop.lab10.authservice.entities.AuthResponse;
import com.sop.lab10.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> logIn(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.logIn(authRequest));
    }

    @GetMapping(value = "/me")
    public ResponseEntity<AuthMeResponse> me(@RequestHeader(value = "id") String id, @RequestHeader(value = "email") String email, @RequestHeader(value = "role") String role) {
        return ResponseEntity.ok(authService.me(id, email, role));
    }

}
