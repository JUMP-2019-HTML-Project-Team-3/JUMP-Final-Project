package com.collabera.finalProject.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.finalProject.dto.UserDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.Login;
import com.collabera.finalProject.model.User;
import com.collabera.finalProject.service.UserService;

@RestController
@RequestMapping("/cognixia")
public class UserController {
	private Mapper mapper;
	
	private final UserService userService;
	/* Initialize final field userService */
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public @ResponseBody User loginUser(@RequestBody Login aUser)
	{
		return userService.checkValidLogin(aUser);
	}
	
	@GetMapping("/check/{user}")
	public @ResponseBody String registerUser(@PathVariable String user)
	{
		if(userService.checkUserExist(user))
			return "e";
		else
			return "n";
	}

	@PostMapping("/adduser")
	public @ResponseBody User addNewUser(@RequestBody @Valid User aUser)
	{
//		User aUser = mapper.UserToEntity(adtoUser);
		return userService.addUser(
				aUser.getUsername(),
				aUser.getPassword(),
				aUser.getEmail(),
				aUser.getUserType()
				);
  	}

  	@GetMapping(path = "/getuser/{id}")
  	public Optional<User> getUserById(@PathVariable Long id)
	{
		return userService.getUserById(id);
	}

	@GetMapping("/allusers")
	public Iterable<User> getAllUsers()
	{
		return userService.findAll();
	}

	@PutMapping("updateuser/{id}")
	public String updateUser(@RequestBody @Valid User user)
	{
		System.out.println("Added User");
		userService.updateUser(user);
		return "Updated";
	}

	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable String id)
	{
		userService.deleteUser(Long.parseLong(id));
	}
}
