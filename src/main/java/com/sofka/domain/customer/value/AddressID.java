package com.sofka.domain.customer.value;

import co.com.sofka.domain.generic.Identity;

public class AddressID extends Identity {

    public AddressID() {

    }

    public AddressID(String id) {
        super(id);
    }

    public static AddressID of (String id){
        return new AddressID(id);
    }

}
