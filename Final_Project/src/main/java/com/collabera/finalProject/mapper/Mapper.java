package com.collabera.finalProject.mapper;

import com.collabera.finalProject.model.*;
import com.collabera.finalProject.dto.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class Mapper {
	
	// Attribute Booleans structure the data views for the service and ultimately the controller
	
	Boolean addressView = false;
	Boolean studentView = false;
	Boolean instructorView = false;
	Boolean clientView = false;
	Boolean resourceView = false;
	Boolean toolView = false;
	Boolean locationView = false;
	Boolean userView = false;
	Boolean userTypeView = false;
	
	// Streams for DTO and Model, using marker interfaces
	private Stream<StudentDTO> studentDTOStream;
	private Stream<Student> studentEntityStream;
	
	private Stream<InstructorDTO> instructorDTOStream;
	private Stream<Instructor> instructorEntitystream;
	
	private Stream<ClientDTO> clientDTOStream;
	private Stream<Client> clientEntityStream;
	
	private Stream<ResourceDTO> resourceDTOStream;
	private Stream<Resource> resourceEntityStream;
	
	private Stream<ToolDTO> toolDTOStream;
	private Stream<Tool> toolEntityStream;
	
	private Stream<LocationDTO> locationDTOStream;
	private Stream<Location> locationEntityStream;
	
	// Getters and Setters for view types
	public Boolean isAddressView() {
		return addressView;
	}

	public void setAddressView(Boolean addressView) {
		this.addressView = addressView;
	}

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

//	private Stream<DTO> getDtoStream() {
//		return dtoStream;
//	}
//
//	private void setDtoStream(Stream<DTO> dtoStream) {
//		this.dtoStream = dtoStream;
//	}

	// Stream handling set and get
//	private static <T> Stream<T> getMapperStream() {
//		return (Stream<T>) mapperStream;
//	}
//
//	private static <T extends DTO> void setMapperStream(Stream<T> streamIn) {
//        mapperStream = streamIn;
//    } 

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
			studentDTOStream = dto.getStudents().stream();
			client.setStudents(studentDTOStream.map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
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
			studentEntityStream = entity.getStudents().stream();
			client.setStudents(studentEntityStream.map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
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
			locationDTOStream = dto.getLocations().stream();
			instructor.setLocations(locationDTOStream.map(s -> LocationToEntity(s)).collect(Collectors.toSet()));
	
			studentDTOStream = dto.getStudents().stream();
			instructor.setStudents(studentDTOStream.map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
	
			toolDTOStream = dto.getTools().stream();
			instructor.setTools(toolDTOStream.map(s -> ToolToEntity(s)).collect(Collectors.toSet()));
	
			resourceDTOStream = dto.getResources().stream();
			instructor.setResources(resourceDTOStream.map(s -> ResourceToEntity(s)).collect(Collectors.toSet()));
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
			locationEntityStream = entity.getLocations().stream();
			instructor.setLocations(locationEntityStream.map(s -> LocationToDTO(s)).collect(Collectors.toSet()));
	
			studentEntityStream = entity.getStudents().stream();
			instructor.setStudents(entity.getStudents().stream().map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
	
			toolEntityStream = entity.getTools().stream();
			instructor.setTools(toolEntityStream.map(s -> ToolToDTO(s)).collect(Collectors.toSet()));
	
			resourceEntityStream = entity.getResources().stream();
			instructor.setResources(resourceEntityStream.map(s -> ResourceToDTO(s)).collect(Collectors.toSet()));
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
			instructorDTOStream = dto.getInstructors().stream();
			location.setInstructors(instructorDTOStream.map(s -> InstructorToEntity(s)).collect(Collectors.toSet()));
	
			studentDTOStream = dto.getStudents().stream();
			location.setStudents(studentDTOStream.map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
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
			instructorEntitystream = entity.getInstructors().stream();
			location.setInstructors(instructorEntitystream.map(s -> InstructorToDTO(s)).collect(Collectors.toSet()));
	
			studentEntityStream = entity.getStudents().stream();
			location.setStudents(studentEntityStream.map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
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
			studentDTOStream = dto.getStudents().stream();
			resource.setStudents(studentDTOStream.map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
	
			instructorDTOStream = dto.getInstructors().stream();
			resource.setInstructors(instructorDTOStream.map(s -> InstructorToEntity(s)).collect(Collectors.toSet()));
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
			studentEntityStream = entity.getStudents().stream();
			resource.setStudents(studentEntityStream.map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
	
			instructorEntitystream = entity.getInstructors().stream();
			resource.setInstructors(instructorEntitystream.map(s -> InstructorToDTO(s)).collect(Collectors.toSet()));
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
			instructorDTOStream = dto.getInstructors().stream();
			student.setInstructors(instructorDTOStream.map(s -> InstructorToEntity(s)).collect(Collectors.toSet()));
	
			clientDTOStream = dto.getClients().stream();
			student.setClients(clientDTOStream.map(s -> ClientToEntity(s)).collect(Collectors.toSet()));
	
			resourceDTOStream = dto.getResources().stream();
			student.setResources(resourceDTOStream.map(s -> ResourceToEntity(s)).collect(Collectors.toSet()));
	
			toolDTOStream = dto.getTools().stream();
			student.setTools(toolDTOStream.map(s -> ToolToEntity(s)).collect(Collectors.toSet()));
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
			instructorEntitystream = entity.getInstructors().stream();
			student.setInstructors(instructorEntitystream.map(s -> InstructorToDTO(s)).collect(Collectors.toSet()));
	
			clientEntityStream = entity.getClients().stream();
			student.setClients(clientEntityStream.map(s -> ClientToDTO(s)).collect(Collectors.toSet()));
	
			resourceEntityStream = entity.getResources().stream();
			student.setResources(resourceEntityStream.map(s -> ResourceToDTO(s)).collect(Collectors.toSet()));
	
			toolEntityStream = entity.getTools().stream();
			student.setTools(toolEntityStream.map(s -> ToolToDTO(s)).collect(Collectors.toSet()));
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
			studentDTOStream = dto.getStudents().stream();
			tool.setStudents(studentDTOStream.map(s -> StudentToEntity(s)).collect(Collectors.toSet()));
	
			instructorDTOStream = dto.getInstructors().stream();
			tool.setInstructors(instructorDTOStream.map(s -> InstructorToEntity(s)).collect(Collectors.toSet()));
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
			studentEntityStream = entity.getStudents().stream();
			tool.setStudents(studentEntityStream.map(s -> StudentToDTO(s)).collect(Collectors.toSet()));
	
			instructorEntitystream = entity.getInstructors().stream();
			tool.setInstructors(instructorEntitystream.map(s -> InstructorToDTO(s)).collect(Collectors.toSet()));
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
	
	public void closeStreams() throws IOException {
		studentDTOStream.close();
		System.out.println("Closed studentDTOStream in the Mapper");

		studentEntityStream.close();
		System.out.println("Closed studentEntityStream in the Mapper");
		
		instructorDTOStream.close();
		System.out.println("Closed instructorDTOStream in the Mapper");
		
		instructorEntitystream.close();
		System.out.println("Closed instructorEntitystream in the Mapper");
		
		clientDTOStream.close();
		System.out.println("Closed clientDTOStream in the Mapper");
		
		clientEntityStream.close();
		System.out.println("Closed clientEntityStream in the Mapper");
		
		resourceDTOStream.close();
		System.out.println("Closed resourceDTOStream in the Mapper");
		
		resourceEntityStream.close();
		System.out.println("Closed resourceEntityStream in the Mapper");
		
		toolDTOStream.close();
		System.out.println("Closed toolDTOStream in the Mapper");
		
		toolEntityStream.close();
		System.out.println("Closed toolEntityStream in the Mapper");
		
		locationDTOStream.close();
		System.out.println("Closed locationDTOStream in the Mapper");
		
		locationEntityStream.close();
		System.out.println("Closed locationEntityStream in the Mapper");
	}
}
