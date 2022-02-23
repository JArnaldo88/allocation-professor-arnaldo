package com.project.professor.allocation.arnaldo.repository;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import com.project.professor.allocation.arnaldo.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void findAll() {
		// Act
		List<Course> course = courseRepository.findAll();

		// Print
		System.out.println(course);
	}
	
	@Test
	public void findById() {
		// Arrange
		Course course = courseRepository.findById(1L).orElse(null);

		// Act

		// Print
		System.out.println(course);
	}

	@Test
	public void save_create() throws ParseException {
		// Arrange
		Course course = new Course();

		course.setName("ADM");
		// Act
		Course courses = courseRepository.save(course);

		// Print
		System.out.println(courses);

	}

	@Test
	public void update() throws ParseException {
		// Arrange
		Course course = new Course();

		course.setName("ADM");
		course.setId(1L);
		// Act
		Course courses = courseRepository.save(course);

		// Print
		System.out.println(courses);

	}

	@Test
	public void deleteById() {
		// Arrange
		courseRepository.deleteById(1L);
		// Act

	}

	@Test
	public void deleteAll() {
		// Act
		courseRepository.deleteAllInBatch();

	}
}