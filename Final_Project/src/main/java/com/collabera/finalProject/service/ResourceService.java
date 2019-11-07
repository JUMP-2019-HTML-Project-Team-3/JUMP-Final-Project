package com.collabera.finalProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.ResourceDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.Resource;
import com.collabera.finalProject.repository.ResourceRepository;

@Service
public class ResourceService {

	@Autowired
	private ResourceRepository resourceRepository;
	
	private Mapper mapper = new Mapper();
	
	//Constructor
	public ResourceService(ResourceRepository resourceRepository)
	{
		this.resourceRepository = resourceRepository;
	}
	
	//Add *Works*
	public void addResource(String name, String link, String description)
	{
		Resource tempResource = new Resource();
		
		tempResource.setName(name);
		tempResource.setLink(link);
		tempResource.setDescription(description);
	
		resourceRepository.save(tempResource);
	}
	
	//Find All
	public List<ResourceDTO> findAll()
	{
		// Set View for mapper
		mapper.setResourceView(true);
		
		return resourceRepository.findAll().stream().map(m -> mapper.ResourceToDTO(m)).collect(Collectors.toList());
	}
	
	//Find by Id
	public Optional<ResourceDTO> getResourceById(Long id)
	{
		// Set Mapper View
		mapper.setResourceView(true);
		// Retrieve, set to Optional in order to use Repository functions, then to DTO
		return Optional.of(mapper.ResourceToDTO(resourceRepository.findById(id).get()));
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
