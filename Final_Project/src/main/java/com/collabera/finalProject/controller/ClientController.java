package com.collabera.finalProject.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.finalProject.dto.ClientDTO;
import com.collabera.finalProject.model.Client;
import com.collabera.finalProject.service.ClientService;


@RestController
@RequestMapping("/cognixia")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	// Create
	@PostMapping(path = "/addclient")
	public String create(@RequestBody @Valid Client client) throws URISyntaxException {
		
		clientService.addClient(client.getName(), client.getImagePath(), client.getPhone(), client.getDescription());
		return "Created";
	}
	
	// Read All
	@GetMapping(path = "/allclients")
	public @ResponseBody Iterable<ClientDTO> getAllClients()
	{
		return clientService.findAll();
	}
	
	// Read One
	@GetMapping(path = "/getclient/{id}")
	public Optional<ClientDTO> getClientById(@PathVariable Long id)
	{
		return clientService.getClientById(id);
	}
	
	// Update
	@PutMapping("/updateclient")
	public String updateClient(@RequestBody @Valid Client client)
	{
		System.out.println("Added Client");
		clientService.updateClient(client);
		return "Updated";
	}
	
	// Delete
	@DeleteMapping("/deleteclient/{id}")
	public void deleteClient(@PathVariable String id)
	{
		clientService.deleteClient(Long.parseLong(id));
	}
}
