package com.sofka.domain.customer.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.customer.value.ReferenceID;
import com.sofka.domain.generic.value.PhoneNumber;

public class ReferencePhoneNumberUpdated extends DomainEvent {

    private final ReferenceID referenceID;
    private final PhoneNumber phoneNumber;

    public ReferencePhoneNumberUpdated(ReferenceID referenceID, PhoneNumber phoneNumber) {
        super("sofka.domain.customer.ReferencePhoneNumberUpdated");
        this.referenceID = referenceID;
        this.phoneNumber = phoneNumber;
    }

    public ReferenceID getReferenceID() {
        return referenceID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
