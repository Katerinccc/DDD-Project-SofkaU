package com.sofka.domain.customer.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.value.FullName;
import com.sofka.domain.generic.value.PhoneNumber;

public class CustomerCreated extends DomainEvent {

    private final FullName fullName;
    private final PhoneNumber phoneNumber;

    public CustomerCreated(FullName fullName, PhoneNumber phoneNumber) {
        super("sofka.domain.customer.CustomerCreated");
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public FullName getFullName() {
        return fullName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
