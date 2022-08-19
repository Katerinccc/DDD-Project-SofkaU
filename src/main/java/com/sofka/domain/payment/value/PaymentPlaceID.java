package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.Identity;

public class PaymentPlaceID extends Identity {

    public PaymentPlaceID() {

    }

    public PaymentPlaceID(String id) {
        super(id);
    }

    public static PaymentPlaceID of (String id){
        return new PaymentPlaceID(id);
    }

}
