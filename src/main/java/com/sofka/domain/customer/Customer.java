package com.sofka.domain.customer;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.customer.event.CustomerCreated;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.generic.value.FullName;
import com.sofka.domain.generic.value.PhoneNumber;
import java.util.List;

public class Customer extends AggregateEvent<CustomerID> {

    protected FullName fullName;
    protected PhoneNumber phoneNumber;
    protected List<Address> addresses;
    protected List<Reference> references;

    private Customer(CustomerID customerID) {
        super(customerID);
        subscribe(new CustomerChange(this));
    }

    public static Customer from(CustomerID customerID, List<DomainEvent> events){
        Customer customer = new Customer(customerID);
        events.forEach(event -> customer.applyEvent(event));
        return customer;
    }

    public Customer(CustomerID entityId,PhoneNumber phoneNumber, FullName fullName){
        super(entityId);
        appendChange(new CustomerCreated(fullName, phoneNumber)).apply();
    }

}
