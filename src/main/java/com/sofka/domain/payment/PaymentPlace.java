package com.sofka.domain.payment;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.payment.value.Location;
import com.sofka.domain.payment.value.PaymentPlaceID;
import com.sofka.domain.payment.value.PlaceType;
import java.util.Objects;

public class PaymentPlace extends Entity<PaymentPlaceID> {

    private PlaceType placeType;
    private Location location;

    public PaymentPlace(PaymentPlaceID entityId, PlaceType placeType, Location location) {
        super(entityId);
        this.placeType = placeType;
        this.location = location;
    }

    public void updatePlaceType(PlaceType placeType){
        this.placeType = Objects.requireNonNull(placeType);
    }

    public void updateLocation(Location location){
        this.location = Objects.requireNonNull(location);
    }

    public PlaceType placeType() {
        return placeType;
    }

    public Location location() {
        return location;
    }
}
