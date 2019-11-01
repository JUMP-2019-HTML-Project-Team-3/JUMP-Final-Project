package com.collabera.finalProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.UserTypeDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.UserType;
import com.collabera.finalProject.repository.UserTypeRepository;

@Service
public class UserTypeService {
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	private Mapper mapper = new Mapper();
	
	//Constructor
	public UserTypeService(UserTypeRepository userTypeRepository)
	{
		this.userTypeRepository = userTypeRepository;
	}
	
	//Add
	public void addUserType(String name)
	{
		UserType tempUserType = new UserType();
		
		tempUserType.setName(name);
	
		userTypeRepository.save(tempUserType);
	}
	
	//Find All
	public List<UserTypeDTO> findAll()
	{
		// Set View for mapper
		mapper.setUserTypeView(true);
		
		return userTypeRepository.findAll().stream().map(m -> mapper.UserTypeToDTO(m)).collect(Collectors.toList());
	}
	
	//Find by Id
	public Optional<UserTypeDTO> getUserTypeById(Long id)
	{
		// Set Mapper View
		mapper.setUserTypeView(true);
		// Retrieve, set to Optional in order to use Repository functions, then to DTO
		return Optional.of(mapper.UserTypeToDTO(userTypeRepository.findById(id).get()));
	}
	
	//Update
	public void updateUserType(UserType userType)
	{
		Optional<UserType> findById = userTypeRepository.findById(userType.getId());
		
		if(findById.isPresent())
		{
			UserType userTypeToUpdate = findById.get();
			
			userTypeToUpdate.setName(userType.getName());

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
	
	// Finalize method to close streams
	@Override
	public void finalize() throws IOException {
		mapper.closeStreams();
	}

}
