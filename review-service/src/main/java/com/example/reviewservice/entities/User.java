package com.example.reviewservice.entities;
import lombok.Data;

@Data
public class User {
    private String _id;
    private String email;
    private String password;
    private String role;
}
