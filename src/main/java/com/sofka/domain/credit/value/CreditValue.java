package com.sofka.domain.credit.value;

import co.com.sofka.domain.generic.ValueObject;

public class CreditValue implements ValueObject<Integer> {

    private final Integer value;

    public CreditValue(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

}
