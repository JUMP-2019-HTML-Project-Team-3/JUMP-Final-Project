package com.collabera.finalProject.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.finalProject.model.Location;
import com.collabera.finalProject.service.LocationService;

@RestController
@RequestMapping("/api")
public class LocationController {
	private final LocationService locationService;
	/* Initialize final field locationService */
	public LocationController (LocationService locationService) {
		this.locationService = locationService;
	}	
	
	@PostMapping(path = "/addlocation")
	public @ResponseBody String addNewLocation(@RequestBody @Valid Location aLocation)
	{
		locationService.addLocation(
				aLocation.getName(), 
				aLocation.getImagePath(),
				aLocation.getPhoneNo()
				);
		return "Saved";
  	}

  	@GetMapping(path = "/getlocation/{id}")
  	public Optional<Location> getLocationById(@PathVariable Long id)
	{
		return locationService.getLocationById(id);
	}

	@GetMapping("/alllocations")
	public Iterable<Location> getAllLocations()
	{
		return locationService.findAll();
	}

	@PutMapping("updatelocation/{id}")
	public String updateLocation(@RequestBody @Valid Location location) {
		System.out.println("Added Location");
		locationService.updateLocation(location);
		return "Updated";
	}
	
	@DeleteMapping("/deletelocation/{id}")
	public void deleteLocation(@PathVariable String id) {
		locationService.deleteLocation(Long.parseLong(id));
	}
}
