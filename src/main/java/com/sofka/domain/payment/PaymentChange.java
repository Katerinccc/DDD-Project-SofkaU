package com.sofka.domain.payment;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.payment.event.PaymentMade;
import com.sofka.domain.payment.event.PaymentMethodAdded;
import com.sofka.domain.payment.event.PaymentPlaceAdded;

public class PaymentChange extends EventChange {

    public PaymentChange(Payment payment){

        apply((PaymentMade event) ->{
            payment.creditID = event.getCreditID();
            payment.paymentValue = event.getPaymentValue();
        });

        apply((PaymentMethodAdded event) ->{
            payment.paymentMethod = new PaymentMethod(
                    event.getPaymentMethodID(),
                    event.getPaymentType(),
                    event.getDescription()
            );
        });

        apply((PaymentPlaceAdded event) -> {
            payment.paymentPlace = new PaymentPlace(
                    event.getPaymentPlaceID(),
                    event.getPlaceType(),
                    event.getLocation()
            );
        });

    }

}
