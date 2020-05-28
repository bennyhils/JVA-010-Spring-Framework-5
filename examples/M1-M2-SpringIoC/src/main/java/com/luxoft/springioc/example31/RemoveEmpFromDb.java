package com.luxoft.springioc.example31;

import org.springframework.context.ApplicationListener;

public class RemoveEmpFromDb implements ApplicationListener<RemoveEmployEvent> {

    public void onApplicationEvent(RemoveEmployEvent event) {
        System.out.println("RemEmployeeToDB#" + Thread.currentThread().getName());
        System.out.println("Employee " + event.getSurname() + " " + event.getFirstName() +
                " is del into the database");

//		throw new RuntimeException();
    }

}
