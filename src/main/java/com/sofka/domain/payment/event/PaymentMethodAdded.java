package com.sofka.domain.payment.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.payment.value.Description;
import com.sofka.domain.payment.value.PaymentMethodID;
import com.sofka.domain.payment.value.PaymentType;

public class PaymentMethodAdded extends DomainEvent {

    private final PaymentMethodID paymentMethodID;
    private final PaymentType paymentType;
    private final Description description;

    public PaymentMethodAdded(PaymentMethodID paymentMethodID, PaymentType paymentType, Description description) {
        super("sofka.domain.payment.PaymentMethodAdded");
        this.paymentMethodID = paymentMethodID;
        this.paymentType = paymentType;
        this.description = description;
    }

    public PaymentMethodID getPaymentMethodID() {
        return paymentMethodID;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Description getDescription() {
        return description;
    }
}
