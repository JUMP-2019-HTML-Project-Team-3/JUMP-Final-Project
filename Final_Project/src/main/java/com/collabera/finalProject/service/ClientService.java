package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.Client;
import com.collabera.finalProject.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	//Constructor
	public ClientService(ClientRepository clientRepository)
	{
		this.clientRepository = clientRepository;
	}
	
	//Add
	public void addClient(String imagePath, String name, String phone, String description)
	{
		Client tempClient = new Client();
		
		tempClient.setImagePath(imagePath);
		tempClient.setName(name);
		tempClient.setPhone(phone);
		tempClient.setDescription(description);
	
		clientRepository.save(tempClient);
	}
	
	//Find All
	public List<Client> findAll()
	{
		return clientRepository.findAll();
	}
	
	//Find by Id
	public Optional<Client> getClientById(Long id)
	{
		return clientRepository.findById(id);
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
