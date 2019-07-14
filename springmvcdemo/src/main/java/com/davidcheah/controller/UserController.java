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
import org.springframework.web.bind.annotation.RestController;

import com.davidcheah.model.User;
import com.davidcheah.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	// http://localhost:8080/users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> foundUsers = service.getAllUsers();
		if (foundUsers.size() > 0) {
			return ResponseEntity.ok(foundUsers);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// http://localhost:8080/users/1
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable int id) {
		User foundUser = service.getUser(id);
		if (foundUser != null) {
			return ResponseEntity.ok(foundUser);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// http://localhost:8080/users
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		User newUser = service.add(user);
		if (newUser != null) {
			return ResponseEntity.ok().body("Added user id: " + newUser.getId());
		} return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// http://localhost:8080/users/1
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
		User updatedUser = service.update(id, user);
		if (updatedUser != null) {
			return ResponseEntity.ok().body("Updated user id: " + updatedUser.getId());
		} return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
	}

	// http://localhost:8080/users/1
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		User removedUser = service.delete(id);
		if (removedUser != null) {
			return ResponseEntity.ok().body("Removed user id: " + removedUser.getId());
		} return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
	}
}
