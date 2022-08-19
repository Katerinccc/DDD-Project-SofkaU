package com.sofka.domain.payment.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentValue;

public class MakePayment extends Command {

    private final PaymentID paymentID;
    private final CreditID creditID;
    private final PaymentValue paymentValue;

    public MakePayment(CreditID creditID, PaymentValue paymentValue) {
        this.paymentID = new PaymentID();
        this.creditID = creditID;
        this.paymentValue = paymentValue;
    }

    public PaymentID getPaymentID() {
        return paymentID;
    }

    public CreditID getCreditID() {
        return creditID;
    }

    public PaymentValue getPaymentValue() {
        return paymentValue;
    }
}
