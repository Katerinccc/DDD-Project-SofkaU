package com.sofka.domain.customer.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.value.PhoneNumber;

public class CustomerMessageSent extends DomainEvent {

    private final String message;

    public CustomerMessageSent(String message) {
        super("sofka.domain.customer.CustomerMessageSent");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
