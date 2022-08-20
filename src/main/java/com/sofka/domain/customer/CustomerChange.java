package com.sofka.domain.customer;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.customer.event.CustomerCreated;
import java.util.ArrayList;

public class CustomerChange extends EventChange {

    public CustomerChange(Customer customer){

        apply((CustomerCreated event) -> {
            customer.fullName = event.getFullName();
            customer.phoneNumber = event.getPhoneNumber();
            customer.addresses = new ArrayList<>();
            customer.references = new ArrayList<>();
        });

    }

}
