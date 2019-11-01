package com.collabera.finalProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.InstructorDTO;
import com.collabera.finalProject.mapper.Mapper;
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
	
	private Mapper mapper = new Mapper();
	
	//Constructor
	public InstructorService(InstructorRepository instructorRepository)
	{
		this.instructorRepository = instructorRepository;
	}
	
	// Create Instructor
	public void addInstructor(String firstName, String lastName, String description, UserType userType, Long long1)
	{
		Instructor tempInstructor = new Instructor();
		
		tempInstructor.setFirstName(firstName);
		tempInstructor.setLastName(lastName);
		tempInstructor.setDescription(description);
		tempInstructor.setUserType(userType);
		instructorRepository. save(tempInstructor);
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
	
	//Find All
	public List<InstructorDTO> findAll()
	{
		// Set View for mapper
		mapper.setInstructorView(true);
		
		return instructorRepository.findAll().stream().map(m -> mapper.InstructorToDTO(m)).collect(Collectors.toList());
	}
	
	//Find by Id
	public Optional<InstructorDTO> getInstructorById(Long id)
	{
		// Set Mapper View
		mapper.setInstructorView(true);
		// Retrieve, set to Optional in order to use Repository functions, then to DTO
		return Optional.of(mapper.InstructorToDTO(instructorRepository.findById(id).get()));
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
	
	@Override
	public void finalize() throws IOException {
		mapper.closeStreams();
	}
	
}
