package com.example.courseRating;

import com.example.courseRating.entity.CourseRating;
import com.example.courseRating.repository.CourseRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CourseRatingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseRatingApplication.class, args);
	}

	@Autowired
	private CourseRatingRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// 添加示例数据
		repository.save(new CourseRating(null, 1L, 5, "Great course!"));
		repository.save(new CourseRating(null, 1L, 4, "Very informative"));
		repository.save(new CourseRating(null, 2L, 3, "Good content, could be better"));
		repository.save(new CourseRating(null, 2L, 2, "Not bad, but could improve"));
		repository.save(new CourseRating(null, 3L, 5, "Excellent!"));
	}
}
