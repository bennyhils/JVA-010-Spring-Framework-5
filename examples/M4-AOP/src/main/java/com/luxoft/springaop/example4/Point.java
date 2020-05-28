package com.luxoft.springaop.example4;

public class Point {
	
	private String name;
	private int x, y;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void draw() {
		System.out.println(this);
	}
	
	public String toString(){
		return "Point " + x + " " + y;
	}

}
