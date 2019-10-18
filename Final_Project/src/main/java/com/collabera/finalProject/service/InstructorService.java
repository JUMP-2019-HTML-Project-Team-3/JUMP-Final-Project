package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.Instructor;
import com.collabera.finalProject.model.Resource;
import com.collabera.finalProject.model.Student;
import com.collabera.finalProject.model.Tool;
import com.collabera.finalProject.model.UserType;
import com.collabera.finalProject.repository.InstructorRepository;


@Service
public class InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	
	//Constructor
	public InstructorService(InstructorRepository instructorRepository)
	{
		this.instructorRepository = instructorRepository;
	}
	
	//Add
	public void addInstructor(String firstName, String lastName, String description)
	{
		Instructor tempInstructor = new Instructor();
		
		tempInstructor.setFirstName(firstName);
		tempInstructor.setLastName(lastName);
		tempInstructor.setDescription(description);
	
		instructorRepository. save(tempInstructor);
	}
	
	//Find All
	public List<Instructor> findAll()
	{
		return instructorRepository.findAll();
	}
	
	//Find by Id
	public Optional<Instructor> getInstructorById(Long id)
	{
		return instructorRepository.findById(id);
	}
	
	//Update
	public void updateAnimal(Instructor instructor)
	{
		Optional<Instructor> findById = instructorRepository.findById(instructor.getId());
		
		if(findById.isPresent())
		{
			Instructor instructorToUpdate = findById.get();
			
			instructorToUpdate.setFirstName(instructor.getFirstName());
			instructorToUpdate.setLastName(instructor.getLastName());
			instructorToUpdate.setDescription(instructor.getDescription());

			instructorRepository.save(instructorToUpdate);
		}
		else
		{
			throw new IllegalArgumentException();
		}
		
	}

	//Delete
	public void deleteAnimal(Long id)
	{
		instructorRepository.deleteById(id);
	}
	
}
