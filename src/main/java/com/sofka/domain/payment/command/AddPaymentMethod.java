package com.sofka.domain.payment.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.payment.value.Description;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentMethodID;
import com.sofka.domain.payment.value.PaymentType;

public class AddPaymentMethod extends Command {

    private final PaymentID paymentID;
    private final PaymentMethodID entityId;
    private final PaymentType paymentType;
    private final Description description;

    public AddPaymentMethod(PaymentID paymentID, PaymentMethodID entityId, PaymentType paymentType, Description description) {
        this.paymentID = paymentID;
        this.entityId = entityId;
        this.paymentType = paymentType;
        this.description = description;
    }

    public PaymentID getPaymentID() {
        return paymentID;
    }

    public PaymentMethodID getEntityId() {
        return entityId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Description getDescription() {
        return description;
    }
}
