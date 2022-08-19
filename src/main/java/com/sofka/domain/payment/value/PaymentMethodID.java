package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.Identity;

public class PaymentMethodID extends Identity {

    public PaymentMethodID() {

    }

    public PaymentMethodID(String id) {
        super(id);
    }

    public static PaymentMethodID of (String id){
        return new PaymentMethodID(id);
    }

}
