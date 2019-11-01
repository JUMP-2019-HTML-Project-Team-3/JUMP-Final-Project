package com.collabera.finalProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.LocationDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.Address;
import com.collabera.finalProject.model.Location;
import com.collabera.finalProject.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	private Mapper mapper = new Mapper();
	
	//Constructor
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	//Add
	public void addLocation(String imagePath, String name, String phoneNo, Address address, Long long1) {
		Location template = new Location();

		template.setImagePath(imagePath);
		template.setName(name);
		template.setPhoneNo(phoneNo);
		template.setAddress(address);
	}

	//Find By Id
	public Optional<LocationDTO> getLocationById(Long id) {
		// Set Mapper View
		mapper.setLocationView(true);
		// Retrieve, set to Optional in order to use Repository functions, then to DTO
		return Optional.of(mapper.LocationToDTO(locationRepository.findById(id).get()));
	}

	//Find All
	public List<LocationDTO> findAll() {
		// Set View for mapper
		mapper.setLocationView(true);
		
		return locationRepository.findAll().stream().map(m -> mapper.LocationToDTO(m)).collect(Collectors.toList());
	}

	//Update
	public void updateLocation(Location location) {
		Optional<Location> findById = locationRepository.findById(location.getId());
		if (findById.isPresent()) {
			Location locationUpdate = findById.get();

			locationUpdate.setImagePath(location.getImagePath());
			locationUpdate.setName(location.getName());
			locationUpdate.setPhoneNo(location.getPhoneNo());
		}
		else throw new IllegalArgumentException();
	}

	//Delete
	public void deleteLocation(Long id) { locationRepository.deleteById(id); }
	
	@Override
	public void finalize() throws IOException {
		mapper.closeStreams();
	}
}
