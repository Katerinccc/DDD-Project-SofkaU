package com.sofka.domain.credit.value;

import co.com.sofka.domain.generic.Identity;

public class StoreID extends Identity {

    public StoreID() {

    }

    public StoreID(String id) {
        super(id);
    }

    public static StoreID of (String id){
        return new StoreID(id);
    }

}
