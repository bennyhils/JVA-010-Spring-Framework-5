package com.luxoft.springioc.example14_tests;

public class LoginManager {
	private UserDirectory userDirectory;

	public UserDirectory getUserDirectory() {
		return userDirectory;
	}

	public void setUserDirectory(UserDirectory userDirectory) {
		this.userDirectory = userDirectory;
	}
}
