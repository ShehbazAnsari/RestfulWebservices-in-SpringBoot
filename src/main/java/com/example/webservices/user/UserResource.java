package com.example.webservices.user;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	//Retrieve All Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return service.findAll();
	}
	
	//Retrieve One User
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return service.findOne(id);
	}
	
	
	//Save Users
	@PostMapping("/users")
	public ResponseEntity<User> saveUsers(@RequestBody User user) {
		User savedUsers = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUsers.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
}
