package com.example.courseRating.service;

import com.example.courseRating.entity.CourseRating;
import com.example.courseRating.repository.CourseRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseRatingService {
    @Autowired
    private CourseRatingRepository repository;

    public List<CourseRating> getRatingsByCourseId(Long courseId) {
        return repository.findByCourseId(courseId);
    }
}
