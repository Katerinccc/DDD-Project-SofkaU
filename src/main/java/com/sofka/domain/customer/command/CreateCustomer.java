package com.sofka.domain.customer.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.generic.value.FullName;
import com.sofka.domain.generic.value.PhoneNumber;

public class CreateCustomer extends Command {

    private final CustomerID customerId;
    private final FullName fullName;
    private final PhoneNumber phoneNumber;

    public CreateCustomer(FullName fullName, PhoneNumber phoneNumber) {
        this.customerId = new CustomerID();
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public CustomerID getCustomerId() {
        return customerId;
    }

    public FullName getFullName() {
        return fullName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

}
