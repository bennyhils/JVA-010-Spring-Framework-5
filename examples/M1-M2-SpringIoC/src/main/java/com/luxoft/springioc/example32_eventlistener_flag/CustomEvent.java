package com.luxoft.springioc.example32_eventlistener_flag;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

	private static final long serialVersionUID = 2545745837098118673L;
	
	private boolean flag;

	public CustomEvent(Object source) {
		super(source);
	}
	
	public CustomEvent(Object source, boolean flag) {
		super(source);
		this.flag = flag;
	}
	
	public boolean isFlag() {
		return flag;
	}

}
