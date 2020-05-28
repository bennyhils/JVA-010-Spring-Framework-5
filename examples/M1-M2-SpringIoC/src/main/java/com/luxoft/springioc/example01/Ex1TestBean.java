package com.luxoft.springioc.example01;

public class Ex1TestBean
{
	private String name;

	public Ex1TestBean()
	{
		System.out.println("#Ex1TestBean -> Created ");
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
