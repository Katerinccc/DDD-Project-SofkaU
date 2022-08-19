package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.ValueObject;

public class PaymentValue implements ValueObject<Integer> {

    private final Integer value;

    public PaymentValue(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

}
