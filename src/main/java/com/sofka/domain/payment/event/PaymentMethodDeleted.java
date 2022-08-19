package com.sofka.domain.payment.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.payment.value.PaymentMethodID;

public class PaymentMethodDeleted extends DomainEvent {

    private final PaymentMethodID paymentMethodID;

    public PaymentMethodDeleted(PaymentMethodID paymentMethodID) {
        super("sofka.domain.payment.PaymentMethodDeleted");
        this.paymentMethodID = paymentMethodID;
    }

    public PaymentMethodID getPaymentMethodID() {
        return paymentMethodID;
    }
}
