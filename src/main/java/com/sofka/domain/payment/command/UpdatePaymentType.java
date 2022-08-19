package com.sofka.domain.payment.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentMethodID;
import com.sofka.domain.payment.value.PaymentType;

public class UpdatePaymentType extends Command {

    private final PaymentID paymentID;
    private final PaymentMethodID entityId;
    private final PaymentType paymentType;

    public UpdatePaymentType(PaymentID paymentID, PaymentMethodID entityId, PaymentType paymentType) {
        this.paymentID = paymentID;
        this.entityId = entityId;
        this.paymentType = paymentType;
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
}
