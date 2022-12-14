package com.sofka.domain.generic.value;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class PhoneNumber implements ValueObject<String> {

    private final String value;

    public PhoneNumber(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
