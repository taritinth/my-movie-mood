package com.sop.movielistservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    private String id;
    private String email;
    private String password;
    private String role;
}
