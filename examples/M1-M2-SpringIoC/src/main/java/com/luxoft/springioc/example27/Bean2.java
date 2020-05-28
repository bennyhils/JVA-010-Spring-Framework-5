package com.luxoft.springioc.example27;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bean2 {


	public void init() {
		System.out.println("User default init method for Bean2");
	}

	public void isajkdhaskjhdkjsahdkjnit() {
		System.out.println("User custom init method for Bean2");
	}
	
	public void cleanup() {
		System.out.println("User custom cleanup method for Bean2");
	}

}
