package com.sofka.domain.customer.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.customer.value.ReferenceID;

public class ReferenceDeleted extends DomainEvent {

    private final ReferenceID referenceID;

    public ReferenceDeleted(ReferenceID referenceID) {
        super("sofka.domain.customer.ReferenceDeleted");
        this.referenceID = referenceID;
    }

    public ReferenceID getReferenceID() {
        return referenceID;
    }

}
