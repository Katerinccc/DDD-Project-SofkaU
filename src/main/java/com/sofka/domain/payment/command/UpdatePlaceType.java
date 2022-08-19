package com.sofka.domain.payment.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentPlaceID;
import com.sofka.domain.payment.value.PlaceType;

public class UpdatePlaceType extends Command {

    private final PaymentID paymentID;
    private final PaymentPlaceID entityId;
    private final PlaceType placeType;

    public UpdatePlaceType(PaymentID paymentID, PaymentPlaceID entityId, PlaceType placeType) {
        this.paymentID = paymentID;
        this.entityId = entityId;
        this.placeType = placeType;
    }

    public PaymentID getPaymentID() {
        return paymentID;
    }

    public PaymentPlaceID getEntityId() {
        return entityId;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }
}
