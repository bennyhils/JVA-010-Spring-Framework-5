package com.luxoft.springioc.example31;

import org.springframework.context.ApplicationEvent;

public class RemoveEmployEvent extends ApplicationEvent {
    private final String surname;
    private final String firstName;

    public RemoveEmployEvent(Object src, String surname, String firstName) {
        super(src);
        this.surname = surname;
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }
}
