package com.project.professor.allocation.arnaldo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.arnaldo.entity.Allocation;
import com.project.professor.allocation.arnaldo.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;

	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}

// CRUD: READ all
	public List<Allocation> findAll() {

		List<Allocation> allocations = allocationRepository.findAll();
		return allocations;
	}
// CRUD: READ by ID

	public Allocation findById(Long id) {

		Optional<Allocation> optional = allocationRepository.findById(id);
		Allocation allocation = optional.orElse(null);
		return allocation;

	}

	// CRUD CREATE
	public Allocation create(Allocation allocation) {

		allocation.setId(null);
		Allocation allocationNew = allocationRepository.save(allocation);
		return allocationNew;

	}

	//CRUD: UPDATE
	
	public Allocation update(Allocation allocation) 
	{
		
		Long id = allocation.getId();
		if (id != null && allocationRepository.existsById(id) )
		{
			Allocation allocationNew = allocationRepository.save(allocation);
			return 	allocationNew;
		}
		else 
		{
			return null;
		}

	}
	
	
	// CRUD : DELETE by ID
	
	public void deleteById(Long id)
	{
		if (allocationRepository.existsById(id))
		{
	
		allocationRepository.deleteById(id);
	
		}

}
	
	//CRUD: DELETE all
	
	public void deleteAll()
	{
		allocationRepository.deleteAllInBatch();
	}
	
	
	
	}

