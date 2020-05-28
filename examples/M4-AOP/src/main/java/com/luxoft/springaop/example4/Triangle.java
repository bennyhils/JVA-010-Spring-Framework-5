package com.luxoft.springaop.example4;

import java.util.List;

public class Triangle {
	
	private String name;
	private String color;
	private List<Point> points; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setNameAndThrowException(String name) {
		this.name = name;
		throw(new RuntimeException());
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		for (Point point : points) {
			System.out.println(point);
		}
		
	}

}
