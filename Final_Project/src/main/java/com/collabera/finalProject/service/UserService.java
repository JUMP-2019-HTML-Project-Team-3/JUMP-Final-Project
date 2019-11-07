package com.collabera.finalProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.UserDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.Login;
import com.collabera.finalProject.model.User;
import com.collabera.finalProject.model.UserType;
import com.collabera.finalProject.repository.UserRepository;
import com.collabera.finalProject.repository.UserTypeRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	private UserTypeRepository userTypeRepository;
	
	private Mapper mapper = new Mapper();
	
	//Constructor
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	public boolean checkUserExist(String username)
	{
		if(userRepository.findByUsername(username).isEmpty())
			return false;
		
		return true;
	}
	
	public User checkValidLogin(Login aUser)
	{
		String username = aUser.getUsername();
		String password = aUser.getPassword();
		
		List<User> users = userRepository.findByUsername(username);
		
		if(users.isEmpty())
			return new User();
		
		if(users.get(0).getUsername().equals(username) && users.get(0).getPassword().equals(password))
			return users.get(0);
		
		return new User();
	}
	
	public boolean createUser(String username, String password, String email, String userType)
	{
		List<User> users = userRepository.findByUsername(username);
		
		if(users.isEmpty())
		{
			UserType useType = new UserType();
			useType.setName(userType);
			
			userTypeRepository.save(useType);
			
			User tempUser = new User();
			
			tempUser.setUsername(username);
			tempUser.setPassword(password);
			tempUser.setEmail(email);
			tempUser.setUserType(useType);
			
			userRepository.save(tempUser);
			return true;
		}
		
		return false;
	}
	
	//Add
	public void addUser(String username, String password, String email, UserType userType, Long long1)
	{
		User tempUser = new User();
		
		tempUser.setUsername(username);
		tempUser.setPassword(password);
		tempUser.setEmail(email);
		tempUser.setUserType(userType);
	}
	
	//Find All
	public List<UserDTO> findAll()
	{
		// Set View for mapper
		mapper.setUserView(true);
		
		return userRepository.findAll().stream().map(m -> mapper.UserToDTO(m)).collect(Collectors.toList());
	}
	
	//Find By Id
	public Optional<UserDTO> getUserById(Long id) 
	{
		// Set Mapper View
		mapper.setUserView(true);
		// Retrieve, set to Optional in order to use Repository functions, then to DTO
		return Optional.of(mapper.UserToDTO(userRepository.findById(id).get()));
	}
	
	//Update
	public void updateUser(User user) 
	{
		Optional<User> findById = userRepository.findById(user.getId());
	
		if(findById.isPresent())
		{
			User userToUpdate = findById.get();
			
			userToUpdate.setUsername(user.getUsername());
			userToUpdate.setPassword(user.getPassword());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setUserType(user.getUserType());
			
			userRepository.save(userToUpdate);
			
		}
		else
		{
			throw new IllegalArgumentException();
		}
		
	}
	
	//Delete
	public void deleteUser(Long id)
	{
		userRepository.deleteById(id);
	}

}
