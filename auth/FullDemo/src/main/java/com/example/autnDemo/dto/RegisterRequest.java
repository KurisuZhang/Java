package com.example.autnDemo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    // Getters and setters
    private String username;
    private String password;
    private String role;

}