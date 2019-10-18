package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.User;
import com.collabera.finalProject.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	public void addUser(String username, String password, String email)
	{
		User tempUser = new User();
		
		tempUser.setUsername(username);
		tempUser.setPassword(password);
		tempUser.setEmail(email);
	}
	
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id) 
	{
		return userRepository.findById(id);
	}
	
	public void updateUser(User user) 
	{
		Optional<User> findById = userRepository.findById(user.getId());
	
		if(findById.isPresent())
		{
			User userToUpdate = findById.get();
			
			userToUpdate.setUsername(user.getUsername());
			userToUpdate.setPassword(user.getPassword());
			userToUpdate.setEmail(user.getEmail());
			
			userRepository.save(userToUpdate);
			
		}
		else
		{
			throw new IllegalArgumentException();
		}
		
	}
	
	public void deleteUser(Long id)
	{
		userRepository.deleteById(id);
	}

}
