package com.davidcheah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davidcheah.model.User;
import com.davidcheah.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> users = service.retrieveUsers();
		return users;
	}
}
