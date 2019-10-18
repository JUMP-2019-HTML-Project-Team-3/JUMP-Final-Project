package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.Address;
import com.collabera.finalProject.model.Location;
import com.collabera.finalProject.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	//Constructor
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	//Add
	public void addLocation(Long id, String imagePath, String name, String phoneNo, Address address) {
		Location template = new Location();

		template.setId(id);
		template.setImagePath(imagePath);
		template.setName(name);
		template.setPhoneNo(phoneNo);
		template.setAddress(address);
	}

	//Find By Id
	public Optional<Location> getLocationById(Long id) {
		return locationRepository.findById(id);
	}

	//Find All
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	//Update
	public void updateLocation(Location location) {
		Optional<Location> findById = locationRepository.findById(location.getId());
		if (findById.isPresent()) {
			Location locationUpdate = findById.get();

			locationUpdate.setImagePath(location.getImagePath());
			locationUpdate.setName(location.getName());
			locationUpdate.setPhoneNo(location.getPhoneNo());
			location.setAddress(location.getAddress());
		}
		else throw new IllegalArgumentException();
	}

	//Delete
	public void deleteLocation(Long id) { locationRepository.deleteById(id); }
}
