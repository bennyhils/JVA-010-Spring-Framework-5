package com.luxoft.springioc.example32_eventlistener;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

	private static final long serialVersionUID = 2545745837098118673L;

	public CustomEvent(Object source) {
		super(source);
	}

}
