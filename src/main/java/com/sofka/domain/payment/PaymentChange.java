package com.sofka.domain.payment;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.payment.event.PaymentMade;

public class PaymentChange extends EventChange {

    public PaymentChange(Payment payment){

        apply((PaymentMade event) ->{
            payment.creditID = event.getCreditID();
            payment.paymentValue = event.getPaymentValue();
        });

    }

}
