package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Location implements ValueObject<String> {

    private final String value;

    public Location(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
