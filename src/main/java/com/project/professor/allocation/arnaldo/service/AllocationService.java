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
		return saveInternal(allocation);

	}

	//CRUD: UPDATE
	
	public Allocation update(Allocation allocation) 
	{
		
		Long id = allocation.getId();
		if (id != null && allocationRepository.existsById(id) )
		{
			allocation.setId(null);
			return saveInternal(allocation);
		}
		else 
		{
			return null;
		}

	}
	
	private Allocation saveInternal(Allocation allocation)
	{
		if (hasCollision(allocation))
		{
			throw new RuntimeException();
		}
		else
		{
			Allocation allocationNew = allocationRepository.save(allocation);
			return 	allocationNew;
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
	boolean hasCollision(Allocation newAllocation) {
		boolean hasCollision = false;

		List<Allocation> currentAllocations = allocationRepository.findByProfessorId(newAllocation.getProfessorId());

		for (Allocation currentAllocation : currentAllocations) {
			hasCollision = hasCollision(currentAllocation, newAllocation);
			if (hasCollision) {
				break;
			}
		}

		return hasCollision;
	}

	private boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
		return !currentAllocation.getId().equals(newAllocation.getId())
				&& currentAllocation.getDay() == newAllocation.getDay()
				&& currentAllocation.getStart().compareTo(newAllocation.getEnd()) < 0
				&& newAllocation.getStart().compareTo(currentAllocation.getEnd()) < 0;
	
	
	}
	
}

