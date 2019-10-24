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

import com.collabera.finalProject.service.ToolService;
import com.collabera.finalProject.model.Tool;


@RestController
@RequestMapping("/cognixia")
public class ToolController {
	
	@Autowired
	private ToolService toolService;
	
	@PostMapping(path = "/addtool")
	public @ResponseBody String addNewTool (@RequestBody @Valid Tool aTool)
	{
		toolService.addTool(
				aTool.getName(), 
				aTool.getLinkDownLoad(), 
				aTool.getLinkDocumentation(), 
				aTool.getDescription());
		
		return "Saved";
	}
	
	@GetMapping(path = "/alltools")
	public @ResponseBody Iterable<Tool> getAllTools()
	{
		return toolService.findAll();
	}
	
	@GetMapping(path = "/gettool/{id}")
	public Optional<Tool> getToolById(@PathVariable Long id)
	{
		return toolService.getToolById(id);
	}
	
	@PutMapping("/updatetool")
	public String updateTool(@RequestBody @Valid Tool tool)
	{
		System.out.println("Added Tool");
		toolService.updateTool(tool);
		return "Updated";
	}
	
	@DeleteMapping("/deletetool/{id}")
	public void deleteTool(@PathVariable String id)
	{
		toolService.deleteTool(Long.parseLong(id));
	}
}
