package com.sofka.domain.customer.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.customer.value.ReferenceID;
import com.sofka.domain.customer.value.Relationship;
import com.sofka.domain.generic.value.FullName;
import com.sofka.domain.generic.value.PhoneNumber;

public class AddReference extends Command {

    private final CustomerID customerId;
    private final ReferenceID referenceId;
    private final FullName fullName;
    private final Relationship relationship;
    private final PhoneNumber phoneNumber;

    public AddReference(CustomerID customerId, ReferenceID referenceId, FullName fullName, Relationship relationship, PhoneNumber phoneNumber) {
        this.customerId = customerId;
        this.referenceId = referenceId;
        this.fullName = fullName;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
    }

    public CustomerID getCustomerId() {
        return customerId;
    }

    public ReferenceID getReferenceId() {
        return referenceId;
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
