package com.luxoft.springioc.example14;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example14/application-context.xml");

		LoginManager loginManager = (LoginManager) context.getBean("loginManager");
		System.out.println(loginManager.getUserDirectory().getClass().getSimpleName());

//		UserDirectorySearch userDirectorySearch = (UserDirectorySearch) context.getBean("userDirectorySearch");
//		System.out.println(userDirectorySearch.getUserDirectory().getClass().getSimpleName());

//		UserInfo userInfo = (UserInfo) context.getBean("userInfo");
//		System.out.println(userInfo.getLdapUserDirectory().getClass().getName());
//
//		System.out.println(loginManager.getUserDirectory() == userDirectorySearch.getUserDirectory());
//		System.out.println(userInfo.getLdapUserDirectory().getClass().getSimpleName());

		context.close();
	}

}
