package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.ClientDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.Address;
import com.collabera.finalProject.model.Client;
import com.collabera.finalProject.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private Mapper mapper;
	
	//Constructor
	public ClientService(ClientRepository clientRepository)
	{
		this.clientRepository = clientRepository;
	}
	
	//Add
	public void addClient(String imagePath, String name, String phone, String description, Address address, Long long1)
	{
		Client tempClient = new Client();
		
		tempClient.setImagePath(imagePath);
		tempClient.setName(name);
		tempClient.setPhone(phone);
		tempClient.setDescription(description);
		tempClient.setAddress(address);
	
		clientRepository.save(tempClient);
	}
	
	//Find All
	public List<ClientDTO> findAll()
	{
		// Set View for mapper
		mapper.setClientView(true);
		
		return clientRepository.findAll().stream().map(m -> mapper.ClientToDTO(m)).collect(Collectors.toList());
	}
	
	//Find by Id
	public Optional<ClientDTO> getClientById(Long id)
	{
		// Set Mapper View
		mapper.setClientView(true);
		// Retrieve, set to Optional in order to use Repository functions, then to DTO
		return Optional.of(mapper.ClientToDTO(clientRepository.findById(id).get()));
	}
	
	//Update
	public void updateClient(Client client)
	{
		Optional<Client> findById = clientRepository.findById(client.getId());
		
		if(findById.isPresent())
		{
			Client clientToUpdate = findById.get();
			
			clientToUpdate.setImagePath(clientToUpdate.getImagePath());
			clientToUpdate.setName(clientToUpdate.getName());
			clientToUpdate.setPhone(clientToUpdate.getPhone());
			clientToUpdate.setDescription(clientToUpdate.getDescription());
			clientToUpdate.setAddress(clientToUpdate.getAddress());
			clientRepository.save(clientToUpdate);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	//Delete
	public void deleteClient(Long id)
	{
		clientRepository.deleteById(id);
	}

	
}
