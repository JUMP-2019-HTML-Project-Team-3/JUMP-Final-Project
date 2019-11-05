package com.collabera.finalProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.ClientDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.Address;
import com.collabera.finalProject.model.Client;
import com.collabera.finalProject.repository.AddressRepository;
import com.collabera.finalProject.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	private Mapper mapper = new Mapper();
	
	
	//Constructor
	public ClientService(ClientRepository clientRepository)
	{
		this.clientRepository = clientRepository;
	}
	
	//Add
	public void addClient(String name, String imagePath, String phone, String description) {
		//Optional<Address> findAddressByID = addressRepository.findById(client.getAddress().getId());
//		findAddressByID.ifPresent(client.setAddress(findAddressByID));

		Client tempClient = new Client(imagePath, name, phone, description);
		clientRepository.save(tempClient);
	}
	
	//Find All
	public List<ClientDTO> findAll()
	{
		// Set View for mapper
		mapper.setClientView(true);
		
		Stream<Client> clientStream = clientRepository.findAll().stream();
		return clientStream.map(m -> mapper.ClientToDTO(m)).collect(Collectors.toList());
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

	// Finalize method to close streams
	@Override
	public void finalize() throws IOException {
		mapper.closeStreams();
	}
	
}
