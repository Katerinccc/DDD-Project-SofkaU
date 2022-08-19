package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.Identity;

public class PlaceID extends Identity {

    public PlaceID() {

    }

    public PlaceID(String id) {
        super(id);
    }

    public static PlaceID of (String id){
        return new PlaceID(id);
    }

}
