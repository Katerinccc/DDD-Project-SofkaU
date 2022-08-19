package com.sofka.domain.customer;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.customer.value.ReferenceID;
import com.sofka.domain.customer.value.Relationship;
import com.sofka.domain.generic.value.FullName;
import com.sofka.domain.generic.value.PhoneNumber;
import java.util.Objects;

public class Reference extends Entity<ReferenceID> {

    private FullName fullName;
    private Relationship relationship;
    private PhoneNumber phoneNumber;

    public Reference(ReferenceID entityId, FullName fullName, Relationship relationship, PhoneNumber phoneNumber) {
        super(entityId);
        this.fullName = fullName;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
    }

    public void updatePhoneNumber(PhoneNumber phoneNumber){
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }

    public FullName fullName() {
        return fullName;
    }

    public Relationship relationship() {
        return relationship;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }
}
