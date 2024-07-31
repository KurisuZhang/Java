package com.example.enrolledCourse.controller;

import com.example.enrolledCourse.entity.EnrolledCourse;
import com.example.enrolledCourse.service.EnrolledCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//8082
@RestController
@RequestMapping("/enrolled-courses")
public class EnrolledCourseController {
    @Autowired
    private EnrolledCourseService service;

    @GetMapping("/{userId}")
    public List<EnrolledCourse> getCoursesByUserId(@PathVariable Long userId) {
        return service.getCoursesByUserId(userId);
    }
}

