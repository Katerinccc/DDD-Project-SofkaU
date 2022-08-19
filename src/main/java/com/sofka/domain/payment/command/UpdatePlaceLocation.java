package com.sofka.domain.payment.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.payment.value.Location;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentPlaceID;

public class UpdatePlaceLocation extends Command {

    private final PaymentID paymentID;
    private final PaymentPlaceID entityId;
    private final Location location;

    public UpdatePlaceLocation(PaymentID paymentID, PaymentPlaceID entityId, Location location) {
        this.paymentID = paymentID;
        this.entityId = entityId;
        this.location = location;
    }

    public PaymentID getPaymentID() {
        return paymentID;
    }

    public PaymentPlaceID getEntityId() {
        return entityId;
    }

    public Location getLocation() {
        return location;
    }
}
