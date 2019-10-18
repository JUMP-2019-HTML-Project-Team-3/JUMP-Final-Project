package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.Student;
import com.collabera.finalProject.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	//Constructor
	public StudentService(StudentRepository studentRepository)
	{
		this.studentRepository = studentRepository;
	}
	
	//Add
	public void addStudent(String imagePath, String firstName, String lastName, String description) {
		
		Student tempStudent = new Student();
		tempStudent.setImagePath(imagePath);
		tempStudent.setFirstName(firstName);
		tempStudent.setLastName(lastName);
		tempStudent.setDescription(description);
	}
	
	//Find All
	public List<Student> findAll()
	{
		return studentRepository.findAll();
	}
	
	//Find By Id
	public Optional<Student> getStudentById(Long id)
	{
		return studentRepository.findById(id);
	}
	
	//Update
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
	
}
