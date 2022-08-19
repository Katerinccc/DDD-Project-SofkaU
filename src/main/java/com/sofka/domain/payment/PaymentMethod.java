package com.sofka.domain.payment;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.payment.value.Description;
import com.sofka.domain.payment.value.PaymentMethodID;
import com.sofka.domain.payment.value.PaymentType;
import java.util.Objects;

public class PaymentMethod extends Entity<PaymentMethodID> {

    private PaymentType paymentType;
    private Description description;

    public PaymentMethod(PaymentMethodID entityId, PaymentType paymentType, Description description) {
        super(entityId);
        this.paymentType = paymentType;
        this.description = description;
    }

    public void updatePaymentType(PaymentType paymentType){
        this.paymentType = Objects.requireNonNull(paymentType);
    }

    public PaymentType paymentType() {
        return paymentType;
    }

    public Description description() {
        return description;
    }
}
