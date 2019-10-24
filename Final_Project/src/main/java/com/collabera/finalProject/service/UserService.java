package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.User;
import com.collabera.finalProject.model.UserType;
import com.collabera.finalProject.repository.UserRepository;
import com.collabera.finalProject.repository.UserTypeRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
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
	
	public boolean checkValidLogin(String username, String password)
	{
		List<User> users = userRepository.findByUsername(username);
		
		if(users.isEmpty())
			return false;
		
		if(users.get(0).getUsername().equals(username) && users.get(0).getPassword().equals(password))
			return true;
		
		return false;
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
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	
	//Find By Id
	public Optional<User> getUserById(Long id) 
	{
		return userRepository.findById(id);
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
