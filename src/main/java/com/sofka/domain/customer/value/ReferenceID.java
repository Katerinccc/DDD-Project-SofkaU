package com.sofka.domain.customer.value;

import co.com.sofka.domain.generic.Identity;

public class ReferenceID extends Identity {

    public ReferenceID() {

    }

    public ReferenceID(String id) {
        super(id);
    }

    public static ReferenceID of (String id){
        return new ReferenceID(id);
    }

}
