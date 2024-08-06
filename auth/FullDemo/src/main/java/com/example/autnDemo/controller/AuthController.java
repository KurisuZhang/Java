package com.example.autnDemo.controller;

import com.example.autnDemo.dto.LoginRequest;
import com.example.autnDemo.dto.RegisterRequest;
import com.example.autnDemo.entity.User;
import com.example.autnDemo.repository.UserRepository;
import com.example.autnDemo.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/oauth2")
    public RedirectView oauth2Login() {
        return new RedirectView("/oauth2/authorization/github");
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(registerRequest.getRole());
        userRepository.save(user);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success register");
        return response;
    }

    @PostMapping("/login")
    public HashMap<String, Object> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
            String role = user.get().getRole();
            HashMap<String, Object> returnMap = new HashMap<>();
            returnMap.put("Login", "Success");
            returnMap.put("jwt", jwtUtil.generateToken(loginRequest.getUsername(), role));
            return returnMap;
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
