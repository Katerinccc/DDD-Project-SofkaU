package com.sofka.domain.payment.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.payment.value.PaymentPlaceID;
import com.sofka.domain.payment.value.PlaceType;

public class PlaceTypeUpdated extends DomainEvent {

    private final PaymentPlaceID paymentPlaceID;
    private final PlaceType placeType;

    public PlaceTypeUpdated(PaymentPlaceID paymentPlaceID, PlaceType placeType) {
        super("sofka.domain.payment.PlaceTypeUpdated");
        this.paymentPlaceID = paymentPlaceID;
        this.placeType = placeType;
    }

    public PaymentPlaceID getPaymentPlaceID() {
        return paymentPlaceID;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }
}
