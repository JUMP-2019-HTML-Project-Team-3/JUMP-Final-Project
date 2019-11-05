package com.collabera.finalProject.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.finalProject.dto.ResourceDTO;
import com.collabera.finalProject.model.Resource;
import com.collabera.finalProject.service.ResourceService;


@RestController
@RequestMapping("/cognixia")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	// Create *Works*
	@PostMapping(path = "/addresource")
	public @ResponseBody String addNewResource (@RequestBody @Valid Resource aResource){
		{
			resourceService.addResource(
					aResource.getName(), 
					aResource.getLink(), 
					aResource.getDescription());
		}
		
		return "Saved";
	}
	
	@GetMapping(path = "allresources")
	public @ResponseBody Iterable <ResourceDTO> getAllResources()
	{
		return resourceService.findAll();
	}
	
	@GetMapping(path = "/getResource/{id}")
	public Optional<ResourceDTO> getResourceById(@PathVariable Long id)
	{
		return resourceService.getResourceById(id);
	}
	
	@PutMapping("/updateresource")
	public String updateResource(@RequestBody @Valid Resource resource)
	{
		System.out.println("Added Resource");
		resourceService.updateResource(resource);
		return "Updated";
	}
	
	@DeleteMapping("/deleteresource/{id}")
	public void deleteResource(@PathVariable String id)
	{
		resourceService.deleteResource(Long.parseLong(id));
	}

}
