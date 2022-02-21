package com.project.professor.allocation.arnaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.professor.allocation.arnaldo.entity.Departament;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long>{

}
