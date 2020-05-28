package com.luxoft.springioc.example11_error;

public class A {

	private B b;

	public A(B b) {
		this.b = b;
	}

	public B getB() {
		return b;
	}

}
