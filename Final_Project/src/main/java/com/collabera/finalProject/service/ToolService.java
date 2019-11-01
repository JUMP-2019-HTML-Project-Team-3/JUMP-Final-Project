package com.collabera.finalProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.ToolDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.Tool;
import com.collabera.finalProject.repository.ToolRepository;

@Service
public class ToolService {

	@Autowired
	private ToolRepository toolRepository;
	
	private Mapper mapper = new Mapper();
	
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
	public List<ToolDTO> findAll()
	{
		// Set View for mapper
		mapper.setToolView(true);
		
		return toolRepository.findAll().stream().map(m -> mapper.ToolToDTO(m)).collect(Collectors.toList());
	}
	
	//Find by Id
	public Optional<ToolDTO> getToolById(Long id)
	{
		// Set Mapper View
		mapper.setToolView(true);
		// Retrieve, set to Optional in order to use Repository functions, then to DTO
		return Optional.of(mapper.ToolToDTO(toolRepository.findById(id).get()));
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
	
	// Finalize method to close streams
	@Override
	public void finalize() throws IOException {
		mapper.closeStreams();
	}
}
