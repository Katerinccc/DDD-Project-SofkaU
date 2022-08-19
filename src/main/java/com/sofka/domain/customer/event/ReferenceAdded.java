package com.sofka.domain.customer.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.customer.value.ReferenceID;
import com.sofka.domain.customer.value.Relationship;
import com.sofka.domain.generic.value.FullName;
import com.sofka.domain.generic.value.PhoneNumber;

public class ReferenceAdded extends DomainEvent {

    private final ReferenceID referenceID;
    private final FullName fullName;
    private final Relationship relationship;
    private final PhoneNumber phoneNumber;

    public ReferenceAdded(ReferenceID referenceID,
                          FullName fullName,
                          Relationship relationship,
                          PhoneNumber phoneNumber)
    {
        super("sofka.domain.customer.ReferenceAdded");
        this.referenceID = referenceID;
        this.fullName = fullName;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
    }

    public ReferenceID getReferenceID() {
        return referenceID;
    }

    public FullName getFullName() {
        return fullName;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
