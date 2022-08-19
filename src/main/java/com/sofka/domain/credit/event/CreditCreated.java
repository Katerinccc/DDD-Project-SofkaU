package com.sofka.domain.credit.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.CreditValue;
import com.sofka.domain.customer.value.CustomerID;

public class CreditCreated extends DomainEvent {

    private final CustomerID customerID;
    private final CreditValue creditValue;

    public CreditCreated(CustomerID customerID, CreditValue creditValue) {
        super("sofka.domain.credit.CreditCreated");
        this.customerID = customerID;
        this.creditValue = creditValue;
    }

    public CustomerID geCustomerID() {
        return customerID;
    }

    public CreditValue getCreditValue() {
        return creditValue;
    }
}
