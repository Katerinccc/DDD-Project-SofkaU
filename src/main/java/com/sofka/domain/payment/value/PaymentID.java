package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.Identity;

public class PaymentID extends Identity {

    public PaymentID() {

    }

    public PaymentID(String id) {
        super(id);
    }

    public static PaymentID of (String id){
        return new PaymentID(id);
    }

}
