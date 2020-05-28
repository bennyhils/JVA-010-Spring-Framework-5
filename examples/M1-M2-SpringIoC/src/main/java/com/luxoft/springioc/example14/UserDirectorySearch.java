package com.luxoft.springioc.example14;

public class UserDirectorySearch {

	private UserDirectory userDirectory;

	public UserDirectorySearch(UserDirectory userDirectory) {
		this.userDirectory = userDirectory;
	}

	public UserDirectorySearch(LDAPUserDirectory userDirectory) {
		this.userDirectory = userDirectory;
	}

}
