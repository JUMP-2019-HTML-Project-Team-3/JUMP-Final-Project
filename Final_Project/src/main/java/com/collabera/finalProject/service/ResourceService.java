package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.Resource;
import com.collabera.finalProject.repository.ResourceRepository;

@Service
public class ResourceService {


	@Autowired
	private ResourceRepository resourceRepository;
	
	//Constructor
	public ResourceService(ResourceRepository resourceRepository)
	{
		this.resourceRepository = resourceRepository;
	}
	
	//Add
	public void addInstructor(String firstName, String lastName, String description)
	{
		Resource tempResource = new Resource();
		
		tempResource.setName(firstName);
		tempResource.setLink(lastName);
		tempResource.setDescription(description);
	
		resourceRepository.save(tempResource);
	}
	
	//Find All
	public List<Resource> findAll()
	{
		return resourceRepository.findAll();
	}
	
	//Find by Id
	public Optional<Resource> getResourceById(Long id)
	{
		return resourceRepository.findById(id);
	}
	
	//Update
	public void updateResource(Resource resource)
	{
		Optional<Resource> findById = resourceRepository.findById(resource.getId());
		
		if(findById.isPresent())
		{
			Resource resourceToUpdate = findById.get();
			
			resourceToUpdate.setName(resource.getName());
			resourceToUpdate.setLink(resource.getLink());
			resourceToUpdate.setDescription(resource.getDescription());

			resourceRepository.save(resourceToUpdate);
		}
		else
		{
			throw new IllegalArgumentException();
		}
		
	}

	//Delete
	public void deleteResource(Long id)
	{
		resourceRepository.deleteById(id);
	}
	
}
