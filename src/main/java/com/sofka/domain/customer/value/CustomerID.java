package com.sofka.domain.customer.value;

import co.com.sofka.domain.generic.Identity;

public class CustomerID extends Identity {

    public CustomerID() {

    }

    public CustomerID(String id) {
        super(id);
    }

    public static CustomerID of (String id){
        return new CustomerID(id);
    }

}
