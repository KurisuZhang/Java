package com.example.autnDemo.security.oauth2;

import com.example.autnDemo.entity.User;
import com.example.autnDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        Optional<User> userOptional = userRepository.findByUsername((String) oAuth2User.getAttributes().get("name"));

        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            // Do something with the user
        } else {
            // Handle the case where the user is not found
            user = new User();
            user.setUsername((String) oAuth2User.getAttributes().get("name"));
            user.setPassword(new BCryptPasswordEncoder().encode("123456"));
            user.setRole("ROLE_USER");
            userRepository.save(user);
        }

        // Custom processing with the oAuth2User
        // For example, mapping custom attributes or roles
        // oAuth2User.getAttributes()

        return oAuth2User;
    }
}
