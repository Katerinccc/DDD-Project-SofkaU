package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.ValueObject;

public class PlaceType implements ValueObject<PlaceTypeE> {

    private final PlaceTypeE value;

    public PlaceType(PlaceTypeE value) {
        this.value = value;
    }

    @Override
    public PlaceTypeE value() {
        return value;
    }


}
