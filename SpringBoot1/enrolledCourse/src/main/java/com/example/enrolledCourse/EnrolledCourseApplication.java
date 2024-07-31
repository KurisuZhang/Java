package com.example.enrolledCourse;

import com.example.enrolledCourse.entity.EnrolledCourse;
import com.example.enrolledCourse.repository.EnrolledCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EnrolledCourseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EnrolledCourseApplication.class, args);
	}

	@Autowired
	private EnrolledCourseRepository enrolledCourseRepository;

	@Override
	public void run(String... args) throws Exception {
		enrolledCourseRepository.save(new EnrolledCourse(null, 1L, 1L));
		enrolledCourseRepository.save(new EnrolledCourse(null, 1L, 2L));
		enrolledCourseRepository.save(new EnrolledCourse(null, 2L, 1L));
		enrolledCourseRepository.save(new EnrolledCourse(null, 2L, 3L));
		enrolledCourseRepository.save(new EnrolledCourse(null, 3L, 2L));
	}
}
