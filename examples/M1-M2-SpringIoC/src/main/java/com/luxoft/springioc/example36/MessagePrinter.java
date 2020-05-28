package com.luxoft.springioc.example36;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    @Autowired
    private MessageService service;

    public void printMessage() {
        System.out.println(service.getMessage());
//        System.out.println("MessagePrinter#Hello");
    }
}

