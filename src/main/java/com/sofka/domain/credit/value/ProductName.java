package com.sofka.domain.credit.value;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class ProductName implements ValueObject<String> {

    private final String value;

    public ProductName(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
