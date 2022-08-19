package com.sofka.domain.customer.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.customer.value.ReferenceID;
import com.sofka.domain.generic.value.PhoneNumber;

public class UpdateReferencePhoneNumber extends Command {

    private final CustomerID customerId;
    private final ReferenceID referenceId;
    private final PhoneNumber phoneNumber;

    public UpdateReferencePhoneNumber(CustomerID customerId, ReferenceID referenceId, PhoneNumber phoneNumber) {
        this.customerId = customerId;
        this.referenceId = referenceId;
        this.phoneNumber = phoneNumber;
    }

    public CustomerID getCustomerId() {
        return customerId;
    }

    public ReferenceID getReferenceId() {
        return referenceId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
