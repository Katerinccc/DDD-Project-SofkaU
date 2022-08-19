package com.sofka.domain.payment.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.payment.value.Location;
import com.sofka.domain.payment.value.PaymentPlaceID;

public class PlaceLocationUpdated extends DomainEvent {

    private final PaymentPlaceID paymentPlaceID;
    private final Location location;

    public PlaceLocationUpdated(PaymentPlaceID paymentPlaceID, Location location) {
        super("sofka.domain.payment.PlaceLocationUpdated");
        this.paymentPlaceID = paymentPlaceID;
        this.location = location;
    }

    public PaymentPlaceID getPaymentPlaceID() {
        return paymentPlaceID;
    }

    public Location getLocation() {
        return location;
    }
}
