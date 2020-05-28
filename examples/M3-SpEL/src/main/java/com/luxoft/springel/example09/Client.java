package com.luxoft.springel.example09;

public class Client {
	private String name;
	private String nationality;
	private String[] accounts;
	private Location location;

	public Client(String name, String nationality, Location location) {
		this.name = name;
		this.nationality = nationality;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setAccounts(String[] accounts) {
		this.accounts = accounts;
	}

	public String[] getAccounts() {
		return accounts;
	}
}
