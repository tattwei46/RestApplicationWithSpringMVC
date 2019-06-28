package com.davidcheah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	//http://localhost:8080/users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		List<User> users = service.getAllUsers();
		return users;
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int id) {
		return service.getUser(id);
	}
		
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {
		User newUser = service.add(user);
		return newUser;
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public @ResponseBody User deleteUser(@PathVariable int id) {
		User removedUser = service.delete(id);
		return removedUser;
	}
}
