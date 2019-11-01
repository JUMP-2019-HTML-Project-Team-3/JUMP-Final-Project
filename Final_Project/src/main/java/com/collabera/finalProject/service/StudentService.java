package com.collabera.finalProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.StudentDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.Student;
import com.collabera.finalProject.model.UserType;
import com.collabera.finalProject.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	private Mapper mapper = new Mapper();
	
	//Constructor
	public StudentService(StudentRepository studentRepository)
	{
		this.studentRepository = studentRepository;
	}
	
	//Add Student
	public void addStudent(String imagePath, String firstName, String lastName, String description, UserType userType, Long long1) {
		
		Student tempStudent = new Student();
		tempStudent.setImagePath(imagePath);
		tempStudent.setFirstName(firstName);
		tempStudent.setLastName(lastName);
		tempStudent.setDescription(description);
		tempStudent.setUserType(userType);
	}
	
	//Add Instructor to Student
	public void addInstructor() {
		
	}
	
	//Add Location to Student
	
	//Add Client to Student
	
	//Add Resource to Student
	
	//Add Tool to Student
	
	//Find All
	public List<StudentDTO> findAll()
	{
		// Set the view for the Mapper
		mapper.setStudentView(true);
		// Retrieve data and convert to DTO
		return studentRepository.findAll().stream().map(m -> mapper.StudentToDTO(m)).collect(Collectors.toList());
	}
	
	//Find By Id
	public Optional<StudentDTO> getStudentById(Long id)
	{
		mapper.setStudentView(true);
		// Retrieve, set to Optional in order to use Repository functions, then to DTO
		return Optional.of(mapper.StudentToDTO(studentRepository.findById(id).get()));
	}
	
	//Update //A change
	public void updateStudent(Student student)
	{
		Optional<Student> findById = studentRepository.findById(student.getId());
		
		if(findById.isPresent())
		{
			Student studentToUpdate = findById.get();
			
			studentToUpdate.setImagePath(student.getImagePath());
			studentToUpdate.setFirstName(student.getFirstName());
			studentToUpdate.setLastName(student.getLastName());
			studentToUpdate.setDescription(student.getDescription());
			studentToUpdate.setUserType((student).getUserType());
			studentRepository.save(studentToUpdate);
		}
		else 
		{
			throw new IllegalArgumentException();
		}
	}
	
	//Delete
	public void deleteStudent(Long id)
	{
		studentRepository.deleteById(id);
	}
	
	// Finalize method to close streams
	@Override
	public void finalize() throws IOException {
		mapper.closeStreams();
	}
	
}
