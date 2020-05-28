package com.luxoft.springaop.example1;

public class UserDTO {
	
	private int id;
	
	public UserDTO(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return "User: " + id;
	}

}
