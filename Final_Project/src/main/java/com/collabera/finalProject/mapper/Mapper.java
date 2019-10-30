package com.collabera.finalProject.mapper;

import com.collabera.finalProject.model.*;
import com.collabera.finalProject.dto.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Mapper {
	
	// Attribute Booleans structure the data views for the service and ultimately the controller
	
	Boolean studentView = false;
	Boolean instructorView = false;
	Boolean clientView = false;
	Boolean resourceView = false;
	Boolean toolView = false;
	Boolean locationView = false;
	Boolean userView = false;
	Boolean userTypeView = false;
	
	// Getters and Setters for view types
	public Boolean isStudentView() {
		return studentView;
	}

	public void setStudentView(Boolean studentView) {
		this.studentView = studentView;
	}

	public Boolean isInstructorView() {
		return instructorView;
	}

	public void setInstructorView(Boolean instructorView) {
		this.instructorView = instructorView;
	}

	public Boolean isClientView() {
		return clientView;
	}

	public void setClientView(Boolean clientView) {
		this.clientView = clientView;
	}

	public Boolean isResourceView() {
		return resourceView;
	}

	public void setResourceView(Boolean resourceView) {
		this.resourceView = resourceView;
	}

	public Boolean isToolView() {
		return toolView;
	}

	public void setToolView(Boolean toolView) {
		this.toolView = toolView;
	}

	public Boolean isLocationView() {
		return locationView;
	}

	public void setLocationView(Boolean locationView) {
		this.locationView = locationView;
	}

	public Boolean isUserView() {
		return userView;
	}

	public void setUserView(Boolean userView) {
		this.userView = userView;
	}

	public Boolean isUserTypeView() {
		return userTypeView;
	}

	public void setUserTypeView(Boolean userTypeView) {
		this.userTypeView = userTypeView;
	}

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
		// Returning students is not necessary if not calling from client controller
		if(clientView) {
			client.setStudents(dto.getStudents().stream().map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
		}
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
		// Return not necessary outside of client controller
		if(clientView) {
			client.setStudents(entity.getStudents().stream().map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
		}
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
		// Only necessary from Instructor Controller
		if(instructorView) {
			instructor.setLocations(dto.getLocations().stream().map(s -> LocationToEntity(s)).collect(Collectors.toSet()));
	
			instructor.setStudents(dto.getStudents().stream().map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
	
			instructor.setTools(dto.getTools().stream().map(s -> ToolToEntity(s)).collect(Collectors.toSet()));
	
			instructor.setResources(dto.getResources().stream().map(s -> ResourceToEntity(s)).collect(Collectors.toSet()));
		}
		
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
		// Only necessary from constructor controller
		if(instructorView) {
			instructor.setLocations(entity.getLocations().stream().map(s -> LocationToDTO(s)).collect(Collectors.toSet()));
	
			instructor.setStudents(entity.getStudents().stream().map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
	
			instructor.setTools(entity.getTools().stream().map(s -> ToolToDTO(s)).collect(Collectors.toSet()));
	
			instructor.setResources(entity.getResources().stream().map(s -> ResourceToDTO(s)).collect(Collectors.toSet()));
		}
		
		return instructor;
	}
	
	// Location
	public Location LocationToEntity(LocationDTO dto) {
		Location location = new Location();
		
		location.setId(dto.getId());
		location.setName(dto.getName());
		location.setPhoneNo(dto.getPhoneNo());
		location.setImagePath(dto.getImagePath());
		location.setAddress(AddressToEntity(dto.getAddress()));
		// Only needed in location controller call
		if(locationView) {
			location.setInstructors(dto.getInstructors().stream().map(s -> InstructorToEntity(s)).collect(Collectors.toSet()));
	
			location.setStudents(dto.getStudents().stream().map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
		}

		return location;
		
	}
	
	public LocationDTO LocationToDTO(Location entity) {
		LocationDTO location = new LocationDTO();
		
		location.setId(entity.getId());
		location.setName(entity.getName());
		location.setPhoneNo(entity.getPhoneNo());
		location.setImagePath(entity.getImagePath());
		location.setAddress(AddressToDTO(entity.getAddress()));
		// Only needed in location view
		if(locationView) {
			location.setInstructors(entity.getInstructors().stream().map(s -> InstructorToDTO(s)).collect(Collectors.toSet()));
	
			location.setStudents(entity.getStudents().stream().map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
		}
		
		return location;
	}
	
	// Resource
	public Resource ResourceToEntity(ResourceDTO dto) {
		Resource resource = new Resource();
		
		resource.setId(dto.getId());
		resource.setName(dto.getName());
		resource.setDescription(dto.getDescription());
		resource.setLink(dto.getLink());
		// Only needed from Resource Controller
		if(resourceView) {
			resource.setStudents(dto.getStudents().stream().map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
	
			resource.setInstructors(dto.getInstructors().stream().map(s -> InstructorToEntity(s)).collect(Collectors.toSet()));
		}
		
		return resource;
		
	}
	
	public ResourceDTO ResourceToDTO(Resource entity) {
		ResourceDTO resource = new ResourceDTO();
		
		resource.setId(entity.getId());
		resource.setName(entity.getName());
		resource.setDescription(entity.getDescription());
		resource.setLink(entity.getLink());
		// Only needed from Resource Controller
		if(resourceView) {
			resource.setStudents(entity.getStudents().stream().map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
	
			resource.setInstructors(entity.getInstructors().stream().map(s -> InstructorToDTO(s)).collect(Collectors.toSet()));
		}
		
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
		// Only need from student controller
		if(studentView) {
			student.setInstructors(dto.getInstructors().stream().map(s -> InstructorToEntity(s)).collect(Collectors.toSet()));
	
			student.setClients(dto.getClients().stream().map(s -> ClientToEntity(s)).collect(Collectors.toSet()));
	
			student.setResources(dto.getResources().stream().map(s -> ResourceToEntity(s)).collect(Collectors.toSet()));
	
			student.setTools(dto.getTools().stream().map(s -> ToolToEntity(s)).collect(Collectors.toSet()));
		}
		
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
		// Only needed from student controller
		if(studentView) {
			student.setInstructors(entity.getInstructors().stream().map(s -> InstructorToDTO(s)).collect(Collectors.toSet()));
	
			student.setClients(entity.getClients().stream().map(s -> ClientToDTO(s)).collect(Collectors.toSet()));
	
			student.setResources(entity.getResources().stream().map(s -> ResourceToDTO(s)).collect(Collectors.toSet()));
	
			student.setTools(entity.getTools().stream().map(s -> ToolToDTO(s)).collect(Collectors.toSet()));
		}
		
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
		// Only needed from Tool Controller
		if(resourceView) {
			tool.setStudents(dto.getStudents().stream().map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
	
			tool.setInstructors(dto.getInstructors().stream().map(s -> InstructorToEntity(s)).collect(Collectors.toSet()));
		}
		
		return tool;
		
	}
	
	public ToolDTO ToolToDTO(Tool entity) {
		ToolDTO tool = new ToolDTO();
		
		tool.setId(entity.getId());
		tool.setName(entity.getName());
		tool.setDescription(entity.getDescription());
		tool.setLinkDownLoad(entity.getLinkDownLoad());
		tool.setLinkDocumentation(entity.getLinkDocumentation());
		// Only needed from Tool Controller
		if(resourceView) {
			tool.setStudents(entity.getStudents().stream().map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
	
			tool.setInstructors(entity.getInstructors().stream().map(s -> InstructorToDTO(s)).collect(Collectors.toSet()));
		}
		
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
