package com.sofka.domain.payment.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.payment.value.PaymentMethodID;
import com.sofka.domain.payment.value.PaymentType;

public class PaymentTypeUpdated extends DomainEvent {

    private final PaymentMethodID paymentMethodID;
    private final PaymentType paymentType;

    public PaymentTypeUpdated(PaymentMethodID paymentMethodID, PaymentType paymentType) {
        super("sofka.domain.payment.PaymentTypeUpdated");
        this.paymentMethodID = paymentMethodID;
        this.paymentType = paymentType;
    }

    public PaymentMethodID getPaymentMethodID() {
        return paymentMethodID;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
