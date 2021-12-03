package com.sop.lab10.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public String getUser(@RequestHeader(value = "id") String userId, @RequestHeader(value = "role") String role) {
        return "User (ID: " + userId + ", role: " + role + ")";
    }
}
