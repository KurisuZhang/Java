package com.example.enrolledCourse.service;

import com.example.enrolledCourse.entity.EnrolledCourse;
import com.example.enrolledCourse.repository.EnrolledCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrolledCourseService {
    @Autowired
    private EnrolledCourseRepository repository;

    public List<EnrolledCourse> getCoursesByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}

