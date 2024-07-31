package com.example.courseCatalog.controller;

import com.example.courseCatalog.entiry.CourseRating;
import com.example.courseCatalog.entiry.EnrolledCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//8081
@RestController
public class CourseCatalogController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/userId/{userId}")
    public List<EnrolledCourse> getCourseDetails(@PathVariable Long userId) {
        ResponseEntity<EnrolledCourse[]> enrolledCoursesResponse = restTemplate.getForEntity(
                "http://ENROLLED-COURSE-SERVICE/enrolled-courses/" + userId, EnrolledCourse[].class);
        EnrolledCourse[] enrolledCoursesArray = enrolledCoursesResponse.getBody();

        return Arrays.asList(enrolledCoursesArray);
    }

    @GetMapping("/courseId/{courseId}")
    public List<CourseRating> getCourseRatings(@PathVariable Long courseId) {
        ResponseEntity<CourseRating[]> ratingsResponse = restTemplate.getForEntity(
                    "http://COURSE-RATING-SERVICE/ratings/" + courseId, CourseRating[].class);
        CourseRating[] courseRatings = ratingsResponse.getBody();
        return Arrays.asList(courseRatings);
    }

}

