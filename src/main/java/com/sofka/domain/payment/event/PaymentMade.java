package com.sofka.domain.payment.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.payment.value.PaymentValue;

public class PaymentMade extends DomainEvent {

    private final CreditID creditID;
    private final PaymentValue paymentValue;

    public PaymentMade(CreditID creditID, PaymentValue paymentValue) {
        super("sofka.domain.payment.PaymentMade");
        this.creditID = creditID;
        this.paymentValue = paymentValue;
    }

    public CreditID getCreditID() {
        return creditID;
    }

    public PaymentValue getPaymentValue() {
        return paymentValue;
    }
}
