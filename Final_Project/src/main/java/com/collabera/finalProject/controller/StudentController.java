package com.collabera.finalProject.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.finalProject.model.Student;
import com.collabera.finalProject.service.StudentService;


@RestController
@RequestMapping("/cognixia")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(path = "/addstudent")
	public @ResponseBody String addNewStudent (@RequestBody @Valid Student aStudent)
	{
		studentService.addStudent(
				aStudent.getImagePath(), 
				aStudent.getFirstName(), 
				aStudent.getLastName(), 
				aStudent.getDescription(),
				aStudent.getUserType(),
				aStudent.getUserType().getId());
		
		return "Saved";
	}
	
	@GetMapping(path = "/allstudents")
	public @ResponseBody Iterable<Student> getAllStudents()
	{
		return studentService.findAll();
	}
	
	@GetMapping(path = "/getstudent/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id)
	{
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/updatestudent")
	public String updateStudent(@RequestBody @Valid Student student)
	{
		System.out.println("Added Student");
		studentService.updateStudent(student);
		return "Updated";
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public void deleteStudent(@PathVariable String id)
	{
		studentService.deleteStudent(Long.parseLong(id));
	}
}
