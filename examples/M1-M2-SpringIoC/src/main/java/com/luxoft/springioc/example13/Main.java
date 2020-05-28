package com.luxoft.springioc.example13;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example13/application-context.xml");

		LoginManager loginManager = (LoginManager) context.getBean("loginManager");
		System.out.println(loginManager.hashCode());

		UserDirectorySearch userDirectorySearch = (UserDirectorySearch) context.getBean("userDirectorySearch");
		System.out.println(userDirectorySearch.hashCode());

		UserInfo userInfo = (UserInfo) context.getBean("userInfo");
		System.out.println(userInfo.hashCode());

		System.out.println(loginManager.getUserDirectory() == userDirectorySearch.getUserDirectory());
		System.out.println(userInfo.getLdapUserDirectory());

		context.close();
	}

}
