package com.example.autnDemo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/ROLE_ADMIN/{message}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getMessageAdmin(@PathVariable String message) {
        return "This is for ROLE_ADMIN: " + message;
    }

    @GetMapping("/ROLE_USER/{message}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getMessageUser(@PathVariable String message) {
        return "This is for ROLE_ADMIN: " + message;
    }

    @GetMapping("/All_ROLE/{message}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String getMessageAllRole(@PathVariable String message) {
        return "This is for All_ROLE: " + message;
    }

}