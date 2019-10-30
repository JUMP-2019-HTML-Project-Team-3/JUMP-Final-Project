package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.Instructor;
import com.collabera.finalProject.model.Location;
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

	//Create Instructor
	public void addInstructor(String firstName, String lastName, String description, UserType userType, Long long1)
	{
		Instructor tempInstructor = new Instructor();
		
		tempInstructor.setFirstName(firstName);
		tempInstructor.setLastName(lastName);
		tempInstructor.setDescription(description);
		tempInstructor.setUserType(userType);

		instructorRepository.save(tempInstructor);
	}

	//Find by Id
	public Optional<Instructor> getInstructorById(Long id)
	{
		return instructorRepository.findById(id);
	}

	//Find All
	public List<Instructor> findAll()
	{
		return instructorRepository.findAll();
	}

	// Add Location
	public void addLocation(Location aLocation, Instructor aInstructor)
	{
		Set<Location> locations = aInstructor.getLocations();
		locations.add(aLocation);
		
		aInstructor.setLocations(locations);
		
		instructorRepository.save(aInstructor);
	}

	// Add/Remove Student
	public void addStudent(Student s, Instructor i)
	{
		i.addStudent(s);
		instructorRepository.save(i);
	}

	public void removeStudent(Student s, Instructor i)
	{
		i.removeStudent(s);
		instructorRepository.save(i);
	}

	// Add/Remove Resource
	public void addResource(Resource r, Instructor i)
	{
		i.addResource(r);
		instructorRepository.save(i);
	}

	public void removeResource(Resource r, Instructor i)
	{
		i.removeResource(r);
		instructorRepository.save(i);
	}

	// Add/Remove Tool
	public void addTool(Tool t, Instructor i)
	{
		i.addTool(t);
		instructorRepository.save(i);
	}

	public void removeTool(Tool t, Instructor i)
	{
		i.removeTool(t);
		instructorRepository.save(i);
	}

	//Update
	public void updateInstructor(Instructor instructor)
	{
		Optional<Instructor> findById = instructorRepository.findById(instructor.getId());

		if(findById.isPresent())
		{
			Instructor instructorToUpdate = findById.get();

			instructorToUpdate.setFirstName(instructor.getFirstName());
			instructorToUpdate.setLastName(instructor.getLastName());
			instructorToUpdate.setDescription(instructor.getDescription());
			instructorToUpdate.setLocations(instructor.getLocations());
			instructorToUpdate.setResources(instructor.getResources());
			instructorToUpdate.setStudents(instructor.getStudents());
			instructorToUpdate.setTools(instructor.getTools());
			instructorToUpdate.setUser(instructor.getUser());
			instructorToUpdate.setUserType(instructor.getUserType());

			instructorRepository.save(instructorToUpdate);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	//Delete
	public void deleteInstructor(Long id)
	{
		instructorRepository.deleteById(id);
	}	
}
