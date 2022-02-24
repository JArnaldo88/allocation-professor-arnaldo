package com.project.professor.allocation.arnaldo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.arnaldo.entity.Allocation;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	AllocationService allocationService;

	@Test
	public void findAll() {
		// Act
		List<Allocation> allocations = allocationService.findAll();

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Arrange
		Long id = 1L;

		// Act
		Allocation allocation = allocationService.findById(id);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void save() throws ParseException {
		// Arrange
		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDay(DayOfWeek.WEDNESDAY);
		allocation.setStart(sdf.parse("19:00-0300"));
		allocation.setEnd(sdf.parse("20:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);

		// Act
		allocation = allocationService.create(allocation);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void update() throws ParseException {
		// Arrange
		Allocation allocation = new Allocation();
		allocation.setId(1L);
		allocation.setDay(DayOfWeek.MONDAY);
		allocation.setStart(sdf.parse("19:00-0300"));
		allocation.setEnd(sdf.parse("20:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);

		// Act
		allocation = allocationService.update(allocation);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void deleteById() {
		// Arrange
		Long id = 1L;

		// Act
		allocationService.deleteById(id);
	}

	@Test
	public void deleteAll() {
		// Act
		allocationService.deleteAll();
	}
}
