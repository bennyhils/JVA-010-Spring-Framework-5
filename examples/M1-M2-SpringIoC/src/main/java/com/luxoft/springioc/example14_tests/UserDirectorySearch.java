package com.luxoft.springioc.example14_tests;

import org.springframework.beans.factory.annotation.Autowired;

public class UserDirectorySearch {

	private UserDirectory userDirectory;

	public UserDirectorySearch(UserDirectory userDirectory) {

		this.userDirectory = userDirectory;

	}

	public UserDirectorySearch(LDAPUserDirectory userDirectory) {

		this.userDirectory = userDirectory;

	}

	public UserDirectory getUserDirectory() {
		return userDirectory;
	}
}
