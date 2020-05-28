package com.luxoft.springioc.example40;

import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class ConsolePrinter implements Printer {

	@Override
	public void print(String text) {
		System.out.println("ConsolePrinter: " + text);
	}

}
