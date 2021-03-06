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

import com.project.professor.allocation.arnaldo.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
	ProfessorRepository professorRepository;
	
	@Test
	public void findAll() {
		// Act
		List<Professor> prof = professorRepository.findAll();

		// Print
		System.out.println(prof);
	}

	@Test
	public void findById() {
	// Arrange
	Professor professor = professorRepository.findById(1L).orElse(null);

	// Act

	// Print
	System.out.println(professor);
	}

	@Test
	public void save_create() throws ParseException {
	// Arrange
	Professor professor = new Professor();
	professor.setName("Tiago Peladeiro");
	professor.setCpf("123456789");
	
	// Act
	Professor prof = professorRepository.save(professor);

	// Print
	System.out.println(prof);

}

	@Test
	public void update() throws ParseException {
	// Arrange
	Professor professor = new Professor();

	professor.setName("Rafael");
	professor.setId(1L);
	professor.setCpf("9");
	
	// Act
	Professor prof = professorRepository.save(professor);

	// Print
	System.out.println(prof);

}

	@Test
	public void deleteById() {
	// Arrange
	professorRepository.deleteById(1L);
	
	// Act

}

	@Test
	public void deleteAll() {
	// Act
	professorRepository.deleteAllInBatch();

	}
}
