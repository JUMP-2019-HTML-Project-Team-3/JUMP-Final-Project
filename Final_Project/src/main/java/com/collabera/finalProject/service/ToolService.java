package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.Tool;
import com.collabera.finalProject.repository.ToolRepository;

@Service
public class ToolService {

	@Autowired
	private ToolRepository toolRepository;
	
	//Constructor
	public ToolService(ToolRepository toolRepository)
	{
		this.toolRepository = toolRepository;
	}
	
	//Add
	public void addTool(String name, String linkDownload, String linkDocumentation, String description)
	{
		Tool tempTool = new Tool();
		
		tempTool.setName(name);
		tempTool.setLinkDownLoad(linkDownload);
		tempTool.setLinkDocumentation(linkDocumentation);
		tempTool.setDescription(description);
	
		toolRepository.save(tempTool);
	}
	
	//Find All
	public List<Tool> findAll()
	{
		return toolRepository.findAll();
	}
	
	//Find by Id
	public Optional<Tool> getToolById(Long id)
	{
		return toolRepository.findById(id);
	}
	
	//Update
	public void updateTool(Tool tool)
	{
		Optional<Tool> findById = toolRepository.findById(tool.getId());
		
		if(findById.isPresent())
		{
			Tool toolToUpdate = findById.get();
			
			toolToUpdate.setName(tool.getName());
			toolToUpdate.setLinkDownLoad(tool.getLinkDownLoad());
			toolToUpdate.setLinkDocumentation(tool.getLinkDocumentation());
			toolToUpdate.setDescription(tool.getDescription());

			toolRepository.save(toolToUpdate);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	//Delete
	public void deleteTool(Long id)
	{
		toolRepository.deleteById(id);
	}
	
}
