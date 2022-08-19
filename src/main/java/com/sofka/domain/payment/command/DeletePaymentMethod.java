package com.sofka.domain.payment.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentMethodID;

public class DeletePaymentMethod extends Command {

    private final PaymentID paymentID;
    private final PaymentMethodID entityId;

    public DeletePaymentMethod(PaymentID paymentID, PaymentMethodID entityId) {
        this.paymentID = paymentID;
        this.entityId = entityId;
    }

    public PaymentID getPaymentID() {
        return paymentID;
    }

    public PaymentMethodID getEntityId() {
        return entityId;
    }
}
