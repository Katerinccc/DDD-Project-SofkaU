package com.sofka.domain.customer.value;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class City implements ValueObject<String> {

    private final String value;

    public City(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
