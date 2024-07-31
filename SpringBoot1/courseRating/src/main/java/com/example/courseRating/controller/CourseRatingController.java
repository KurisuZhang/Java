package com.example.courseRating.controller;

import com.example.courseRating.entity.CourseRating;
import com.example.courseRating.service.CourseRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//8080
@RestController
@RequestMapping("/ratings")
public class CourseRatingController {
    @Autowired
    private CourseRatingService service;

    @GetMapping("/{courseId}")
    public List<CourseRating> getRatingsByCourseId(@PathVariable Long courseId) {
        return service.getRatingsByCourseId(courseId);
    }
}

