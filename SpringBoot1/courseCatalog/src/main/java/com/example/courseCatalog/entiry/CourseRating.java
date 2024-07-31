package com.example.courseCatalog.entiry;

import lombok.Getter;

@Getter
public class CourseRating {
    private Long id;
    private Long courseId;
    private int rating;
    private String comment;
    // Getters and setters
}

