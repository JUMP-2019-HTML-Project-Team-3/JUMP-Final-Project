package com.collabera.finalProject.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.finalProject.model.Instructor;
import com.collabera.finalProject.service.InstructorService;

@RestController
@RequestMapping("/cognixia")
public class InstructorController {
	private final InstructorService instructorService;
	/* Initialize final field instructorService */
	public InstructorController (InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	@PostMapping("/addinstructor")
	public @ResponseBody String addNewInstructor(@RequestBody @Valid Instructor aInstructor)
	{
		instructorService.addInstructor(
				aInstructor.getFirstName(),
				aInstructor.getLastName(),
				aInstructor.getDescription(),
				aInstructor.getUserType(),
				aInstructor.getUserType().getId()
				);
		return "Saved";
  	}

  	@GetMapping(path = "/getinstructor/{id}")
  	public Optional<Instructor> getInstructorById(@PathVariable Long id)
	{
		return instructorService.getInstructorById(id);
	}

	@GetMapping("/allinstructors")
	public Iterable<Instructor> getAllInstructors()
	{
		return instructorService.findAll();
	}

	@PutMapping("/updateinstructor/{id}")
	public String updateInstructor(@RequestBody @Valid Instructor instructor)
	{
		System.out.println("Added Instructor");
		instructorService.updateInstructor(instructor);
		return "Updated";
	}

	@DeleteMapping("/deleteinstructor/{id}")
	public void deleteInstructor(@PathVariable String id)
	{
		instructorService.deleteInstructor(Long.parseLong(id));
	}
}
