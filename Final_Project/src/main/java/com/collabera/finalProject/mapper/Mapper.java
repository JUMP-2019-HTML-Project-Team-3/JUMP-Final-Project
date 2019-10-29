package com.collabera.finalProject.mapper;

import com.collabera.finalProject.model.*;
import com.collabera.finalProject.dto.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Mapper {
	
	// Address
	public Address AddressToEntity(AddressDTO dto) {
		Address address = new Address();
		
		address.setId(dto.getId());
		address.setStreetNumber(dto.getStreetNumber());
		address.setStreetName(dto.getStreetName());
		address.setSuiteNo(dto.getSuiteNo());
		address.setTownship(dto.getTownship());
		address.setState(dto.getState());
		address.setZip(dto.getZip());
		address.setCountry(dto.getCountry());
		
		return address;
		
	}
	
	public AddressDTO AddressToDTO(Address entity) {
		AddressDTO address = new AddressDTO();
		
		address.setId(entity.getId());
		address.setStreetNumber(entity.getStreetNumber());
		address.setStreetName(entity.getStreetName());
		address.setSuiteNo(entity.getSuiteNo());
		address.setTownship(entity.getTownship());
		address.setState(entity.getState());
		address.setZip(entity.getZip());
		address.setCountry(entity.getCountry());
		
		return address;
	}
	
	// Client
	public Client ClientToEntity(ClientDTO dto) {
		Client client = new Client();
		
		client.setId(dto.getId());
		client.setName(dto.getName());
		client.setImagePath(dto.getImagePath());
		client.setDescription(dto.getDescription());
		client.setPhone(dto.getPhone());
		dto.getStudents().stream().iterator().forEachRemaining(s -> {client.addStudent(StudentToEntity(s));});
		client.setAddress(AddressToEntity(dto.getAddress()));
		
		return client;
		
	}
	
	public ClientDTO ClientToDTO(Client entity) {
		ClientDTO client = new ClientDTO();
		
		client.setId(entity.getId());
		client.setName(entity.getName());
		client.setImagePath(entity.getImagePath());
		client.setDescription(entity.getDescription());
		client.setPhone(entity.getPhone());
		entity.getStudents().stream().iterator().forEachRemaining(s -> {client.addStudent(StudentToDTO(s));});
		client.setAddress(AddressToDTO(entity.getAddress()));
		
		return client;
	}
	
	// Instructor
	public Instructor InstructorToEntity(InstructorDTO dto) {
		Instructor instructor = new Instructor();
		
		instructor.setId(dto.getId());
		instructor.setFirstName(dto.getFirstName());
		instructor.setLastName(dto.getLastName());
		instructor.setUser(UserToEntity(dto.getUser()));
		instructor.setUserType(UserTypeToEntity(dto.getUserType()));
		instructor.setDescription(dto.getDescription());
		dto.getLocations().stream().iterator().forEachRemaining(s -> {instructor.addLocation(LocationToEntity(s));});
		dto.getStudents().stream().iterator().forEachRemaining(s -> {instructor.addStudent(StudentToEntity(s));});
		dto.getTools().stream().iterator().forEachRemaining(s -> {instructor.addTool(ToolToEntity(s));});
		dto.getResources().stream().iterator().forEachRemaining(s -> {instructor.addResource(ResourceToEntity(s));});
		
		return instructor;
		
	}
	
	public InstructorDTO InstructorToDTO(Instructor entity) {
		InstructorDTO instructor = new InstructorDTO();
		
		instructor.setId(entity.getId());
		instructor.setFirstName(entity.getFirstName());
		instructor.setLastName(entity.getLastName());
		instructor.setUser(UserToDTO(entity.getUser()));
		instructor.setUserType(UserTypeToDTO(entity.getUserType()));
		instructor.setDescription(entity.getDescription());
		entity.getLocations().stream().iterator().forEachRemaining(s -> {instructor.addLocation(LocationToDTO(s));});
		entity.getStudents().stream().iterator().forEachRemaining(s -> {instructor.addStudent(StudentToDTO(s));});
		entity.getTools().stream().iterator().forEachRemaining(s -> {instructor.addTool(ToolToDTO(s));});
		entity.getResources().stream().iterator().forEachRemaining(s -> {instructor.addResource(ResourceToDTO(s));});
		
		return instructor;
	}
	
	// Location
	public Location LocationToEntity(LocationDTO dto) {
		Location location = new Location();
		
		location.setId(dto.getId());
		location.setName(dto.getName());
		location.setPhoneNo(dto.getPhoneNo());
		location.setImagePath(dto.getImagePath());
		dto.getInstructors().stream().iterator().forEachRemaining(s -> {location.addInstructor(InstructorToEntity(s));});
		dto.getStudents().stream().iterator().forEachRemaining(s -> {location.addStudent(StudentToEntity(s));});
		location.setAddress(AddressToEntity(dto.getAddress()));
		
		return location;
		
	}
	
	public LocationDTO LocationToDTO(Location entity) {
		LocationDTO location = new LocationDTO();
		
		location.setId(entity.getId());
		location.setName(entity.getName());
		location.setPhoneNo(entity.getPhoneNo());
		location.setImagePath(entity.getImagePath());
		entity.getInstructors().stream().iterator().forEachRemaining(s -> {location.addInstructor(InstructorToDTO(s));});
		entity.getStudents().stream().iterator().forEachRemaining(s -> {location.addStudent(StudentToDTO(s));});
		location.setAddress(AddressToDTO(entity.getAddress()));
		
		return location;
	}
	
	// Resource
	public Resource ResourceToEntity(ResourceDTO dto) {
		Resource resource = new Resource();
		
		resource.setId(dto.getId());
		resource.setName(dto.getName());
		resource.setDescription(dto.getDescription());
		resource.setLink(dto.getLink());
		dto.getStudents().stream().iterator().forEachRemaining(s -> {resource.addStudent(StudentToEntity(s));});
		dto.getInstructors().stream().iterator().forEachRemaining(s -> {resource.addInstructor(InstructorToEntity(s));});
		
		return resource;
		
	}
	
	public ResourceDTO ResourceToDTO(Resource entity) {
		ResourceDTO resource = new ResourceDTO();
		
		resource.setId(entity.getId());
		resource.setName(entity.getName());
		resource.setDescription(entity.getDescription());
		resource.setLink(entity.getLink());
		entity.getStudents().stream().iterator().forEachRemaining(s -> {resource.addStudent(StudentToDTO(s));});
		entity.getInstructors().stream().iterator().forEachRemaining(s -> {resource.addInstructor(InstructorToDTO(s));});
		
		return resource;
	}
	
	// Student
	public Student StudentToEntity(StudentDTO dto) {
		Student student = new Student();
		
		student.setId(dto.getId());
		student.setFirstName(dto.getFirstName());
		student.setLastName(dto.getLastName());
		student.setImagePath(dto.getImagePath());
		student.setDescription(dto.getDescription());
		student.setUser(UserToEntity(dto.getUser()));
		student.setUserType(UserTypeToEntity(dto.getUserType()));
		dto.getInstructors().stream().iterator().forEachRemaining(s -> {student.addInstructor(InstructorToEntity(s));});
		dto.getClients().stream().iterator().forEachRemaining(s -> {student.addClient(ClientToEntity(s));});
		dto.getResources().stream().iterator().forEachRemaining(s -> {student.addResource(ResourceToEntity(s));});
		dto.getTools().stream().iterator().forEachRemaining(s -> {student.addTool(ToolToEntity(s));});
		
		return student;
		
	}
	
	public StudentDTO StudentToDTO(Student entity) {
		StudentDTO student = new StudentDTO();
		
		student.setId(entity.getId());
		student.setFirstName(entity.getFirstName());
		student.setLastName(entity.getLastName());
		student.setImagePath(entity.getImagePath());
		student.setDescription(entity.getDescription());
		student.setUser(UserToDTO(entity.getUser()));
		student.setUserType(UserTypeToDTO(entity.getUserType()));
		entity.getInstructors().stream().iterator().forEachRemaining(s -> {student.addInstructor(InstructorToDTO(s));});
		entity.getClients().stream().iterator().forEachRemaining(s -> {student.addClient(ClientToDTO(s));});
		entity.getResources().stream().iterator().forEachRemaining(s -> {student.addResource(ResourceToDTO(s));});
		entity.getTools().stream().iterator().forEachRemaining(s -> {student.addTool(ToolToDTO(s));});
		
		return student;
	}
	
	// Tool
	public Tool ToolToEntity(ToolDTO dto) {
		Tool tool = new Tool();
		
		tool.setId(dto.getId());
		tool.setName(dto.getName());
		tool.setDescription(dto.getDescription());
		tool.setLinkDownLoad(dto.getLinkDownLoad());
		tool.setLinkDocumentation(dto.getLinkDocumentation());
		dto.getInstructors().stream().iterator().forEachRemaining(s -> {tool.addInstructor(InstructorToEntity(s));});
		dto.getStudents().stream().iterator().forEachRemaining(s -> {tool.addStudent(StudentToEntity(s));});
		
		return tool;
		
	}
	
	public ToolDTO ToolToDTO(Tool entity) {
		ToolDTO tool = new ToolDTO();
		
		tool.setId(entity.getId());
		tool.setName(entity.getName());
		tool.setDescription(entity.getDescription());
		tool.setLinkDownLoad(entity.getLinkDownLoad());
		tool.setLinkDocumentation(entity.getLinkDocumentation());
		entity.getInstructors().stream().iterator().forEachRemaining(s -> {tool.addInstructor(InstructorToDTO(s));});
		entity.getStudents().stream().iterator().forEachRemaining(s -> {tool.addStudent(StudentToDTO(s));});
		
		return tool;
	}
	
	// User
	public User UserToEntity(UserDTO dto) {
		User user = new User();
		
		user.setId(dto.getId());
		user.setUserType(UserTypeToEntity(dto.getUserType()));
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		
		return user;
		
	}
	
	public UserDTO UserToDTO(User entity) {
		UserDTO user = new UserDTO();
		
		user.setId(entity.getId());
		user.setUserType(UserTypeToDTO(entity.getUserType()));
		user.setUsername(entity.getUsername());
		user.setPassword(entity.getPassword());
		
		return user;
	}
	
	// UserType
	public UserType UserTypeToEntity(UserTypeDTO dto) {
		UserType userType = new UserType();
		
		userType.setId(dto.getId());
		userType.setName(dto.getName());
		
		return userType;
		
	}
	
	public UserTypeDTO UserTypeToDTO(UserType entity) {
		UserTypeDTO userType = new UserTypeDTO();
		
		userType.setId(entity.getId());
		userType.setName(entity.getName());
		
		return userType;
	}
}
