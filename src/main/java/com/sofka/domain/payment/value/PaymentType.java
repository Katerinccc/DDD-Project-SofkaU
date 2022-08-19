package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class PaymentType implements ValueObject<String> {

    private final String value;

    public PaymentType(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
