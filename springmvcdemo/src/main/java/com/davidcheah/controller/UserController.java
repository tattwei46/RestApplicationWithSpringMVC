package com.davidcheah.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.davidcheah.model.User;
import com.davidcheah.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	// http://localhost:8080/users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		List<User> users = service.getAllUsers();
		return users;
	}

	// http://localhost:8080/users/1
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int id) {
		return service.getUser(id);
	}

	// http://localhost:8080/users
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		User newUser = service.add(user);
		if (newUser != null) {
			return new ResponseEntity<String>("Added user id: " + newUser.getId(), HttpStatus.OK);
		} return new ResponseEntity<String>("User not found", HttpStatus.NOT_IMPLEMENTED);
	}

	// http://localhost:8080/users
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
		User updatedUser = service.update(id, user);
		if (updatedUser != null) {
			return new ResponseEntity<String>("Updated user id: " + updatedUser.getId(), HttpStatus.OK);
		} return new ResponseEntity<String>("User not found", HttpStatus.NOT_IMPLEMENTED);
	}

	// http://localhost:8080/users/1
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		User removedUser = service.delete(id);
		if (removedUser != null) {
			return new ResponseEntity<String>("Removed user id: " + removedUser.getId(), HttpStatus.OK);
		} return new ResponseEntity<String>("User not found", HttpStatus.NOT_IMPLEMENTED);
	}
}
