package com.luxoft.springioc.example32_eventlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Bean {

	@EventListener
    public void blogModified(CustomEvent customEvent) {
		System.out.println("CustomEvent received through @EventListener");
    }

}
