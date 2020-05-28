package com.luxoft.springioc.example20;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

public class MovieFinder {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void init()
	{

	}

}
