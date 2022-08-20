package com.sofka.domain.generic.event;

import co.com.sofka.domain.generic.DomainEvent;

public class NotificationSent extends DomainEvent {

    private final String message;

    public NotificationSent(String message) {
        super("sofka.domain.generic.NotificationSent");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
