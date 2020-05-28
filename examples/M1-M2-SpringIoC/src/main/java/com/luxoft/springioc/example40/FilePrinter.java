package com.luxoft.springioc.example40;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FilePrinter implements Printer {

	@Override
	public void print(String text) {
		System.out.println("FilePrinter: " + text);
	}

}
