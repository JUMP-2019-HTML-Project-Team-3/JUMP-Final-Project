package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.UserType;
import com.collabera.finalProject.repository.UserTypeRepository;

@Service
public class UserTypeService {
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	//Constructor
	public UserTypeService(UserTypeRepository userTypeRepository)
	{
		this.userTypeRepository = userTypeRepository;
	}
	
	//Add
	public void addUserType(String imagePath, String name, String phone, String description)
	{
		UserType tempUserType = new UserType();
		
		tempUserType.setImagePath(imagePath);
		tempUserType.setName(name);
		tempUserType.setPhone(phone);
		tempUserType.setDescription(description);
	
		userTypeRepository.save(tempUserType);
	}
	
	//Find All
	public List<UserType> findAll()
	{
		return userTypeRepository.findAll();
	}
	
	//Find by Id
	public Optional<UserType> getUserTypeById(Long id)
	{
		return userTypeRepository.findById(id);
	}
	
	//Update
	public void updateUserType(UserType userType)
	{
		Optional<UserType> findById = userTypeRepository.findById(userType.getId());
		
		if(findById.isPresent())
		{
			UserType userTypeToUpdate = findById.get();
			
			userTypeToUpdate.setImagePath(userTypeToUpdate.getImagePath());
			userTypeToUpdate.setName(userTypeToUpdate.getName());
			userTypeToUpdate.setPhone(userTypeToUpdate.getPhone());
			userTypeToUpdate.setDescription(userTypeToUpdate.getDescription());

			userTypeRepository.save(userTypeToUpdate);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	//Delete
	public void deleteUserType(Long id)
	{
		userTypeRepository.deleteById(id);
	}

}
