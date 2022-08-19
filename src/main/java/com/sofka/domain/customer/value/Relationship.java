package com.sofka.domain.customer.value;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Relationship implements ValueObject<String> {

    private final String value;

    public Relationship(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
