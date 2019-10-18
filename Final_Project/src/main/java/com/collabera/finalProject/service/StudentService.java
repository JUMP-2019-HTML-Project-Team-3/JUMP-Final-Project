package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.Instructor;
import com.collabera.finalProject.model.Student;
import com.collabera.finalProject.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository)
	{
		this.studentRepository = studentRepository;
	}
	
	public void addStudent(String imagePath, String firstName, String lastName, String description) {
		
		Student tempStudent = new Student();
		
		tempStudent.setImagePath(imagePath);
		tempStudent.setFirstName(firstName);
		tempStudent.setLastName(lastName);
		tempStudent.setDescription(description);
	}
	
	public List<Student> findAll()
	{
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudentById(Long id)
	{
		return studentRepository.findById(id);
	}
	
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
	
	public void deleteStudent(Long id)
	{
		studentRepository.deleteById(id);
	}
	
}
