package com.example.autnDemo;

import com.example.autnDemo.entity.User;
import com.example.autnDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword(passwordEncoder.encode("user"));
        user1.setRole("ROLE_USER");

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword(passwordEncoder.encode("admin"));
        user2.setRole("ROLE_ADMIN");

        userRepository.save(user1);
        userRepository.save(user2);
    }
}

