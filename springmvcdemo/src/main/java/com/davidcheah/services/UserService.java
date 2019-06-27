package com.davidcheah.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.davidcheah.model.User;

@Service
public class UserService {

	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1, "Tony Stark", "ironman@avengers.inc"));
		users.add(new User(1, "Steve Rogers", "captain@avengers.inc"));
		users.add(new User(1, "Bruce Banner", "hulk@avengers.inc"));
	}
	
	public List<User> retrieveUsers() {
		return users;
	}
	
}
