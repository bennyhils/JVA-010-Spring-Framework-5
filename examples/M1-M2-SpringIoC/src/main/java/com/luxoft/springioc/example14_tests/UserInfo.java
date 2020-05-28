package com.luxoft.springioc.example14_tests;


public class UserInfo {

	private LDAPUserDirectory ldapUserDirectory;

	public LDAPUserDirectory getLdapUserDirectory() {
		return ldapUserDirectory;
	}

	public void setLdapUserDirectory(LDAPUserDirectory ldapUserDirectory) {
		this.ldapUserDirectory = ldapUserDirectory;
	}
}
