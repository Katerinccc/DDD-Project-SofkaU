package com.sofka.domain.payment.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.payment.value.Location;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentPlaceID;
import com.sofka.domain.payment.value.PlaceType;

public class AddPaymentPlace extends Command {

    private final PaymentID paymentID;
    private final PaymentPlaceID entityId;
    private final PlaceType placeType;
    private final Location location;

    public AddPaymentPlace(PaymentID paymentID, PaymentPlaceID entityId, PlaceType placeType, Location location) {
        this.paymentID = paymentID;
        this.entityId = entityId;
        this.placeType = placeType;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }
}
