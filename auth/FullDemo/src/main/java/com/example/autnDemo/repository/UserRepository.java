package com.example.autnDemo.repository;

import com.example.autnDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @NonNull
    Optional<User> findByUsername(@NonNull String username);

    @NonNull
    Optional<User> findById(@NonNull Long ID);
}
