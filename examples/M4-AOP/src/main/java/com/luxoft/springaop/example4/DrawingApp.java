package com.luxoft.springaop.example4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example4/aop.xml");  
		
		Triangle triangle = (Triangle) context.getBean("triangle");
		
		triangle.draw();
		System.out.println(triangle.getName());
		triangle.setName("new_triangle_name");
		try {
		    triangle.setNameAndThrowException("exception_name");
		} catch (Exception exception) {
			
		}
		
		System.out.println(triangle.getColor());
		
		for (Point point : triangle.getPoints()) {
			System.out.println(point.getName());
			point.draw();
		}
		
		Circle circle = (Circle) context.getBean("circle");
		System.out.println(circle.area());
		
		context.close();
	}

}
