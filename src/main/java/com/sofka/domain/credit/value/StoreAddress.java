package com.sofka.domain.credit.value;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class StoreAddress implements ValueObject<String> {

    private final String value;

    public StoreAddress(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
