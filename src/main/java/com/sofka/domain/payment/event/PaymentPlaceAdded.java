package com.sofka.domain.payment.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.payment.value.Location;
import com.sofka.domain.payment.value.PaymentPlaceID;
import com.sofka.domain.payment.value.PlaceType;

public class PaymentPlaceAdded extends DomainEvent {

    private final PaymentPlaceID paymentPlaceID;
    private final PlaceType placeType;
    private final Location location;

    public PaymentPlaceAdded(PaymentPlaceID paymentPlaceID, PlaceType placeType, Location location) {
        super("sofka.domain.payment.PaymentPlaceAdded");
        this.paymentPlaceID = paymentPlaceID;
        this.placeType = placeType;
        this.location = location;
    }

    public PaymentPlaceID getPaymentPlaceID() {
        return paymentPlaceID;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public Location getLocation() {
        return location;
    }
}
