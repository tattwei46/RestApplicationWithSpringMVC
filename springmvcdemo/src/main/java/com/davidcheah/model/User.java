package com.davidcheah.model;

public class User {
	public User(int i, String name, String email) {
		super();
		this.id = i;
		this.name = name;
		this.email = email;
	}

	private int id;
	private String name;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
