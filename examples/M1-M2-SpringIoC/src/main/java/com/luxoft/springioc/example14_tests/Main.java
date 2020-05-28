package com.luxoft.springioc.example14_tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example14_tests/application-context.xml");

		LoginManager loginManager = (LoginManager) context.getBean("loginManager");
		print(loginManager.getUserDirectory());

		UserDirectorySearch userDirectorySearch = (UserDirectorySearch) context.getBean("userDirectorySearch");
		print(userDirectorySearch.getUserDirectory());

		UserInfo userInfo = (UserInfo) context.getBean("userInfo");
		print(userInfo.getLdapUserDirectory());

		context.close();
	}

	public static void print(UserDirectory userDirectory) {

		if (userDirectory == null) {
			System.out.println("null");
			return;
		}
		System.out.println(userDirectory.getClass().getSimpleName());
	}

}
