package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.ValueObject;

public class MethodType implements ValueObject<MethodTypeE> {

    private final MethodTypeE value;

    public MethodType(MethodTypeE value) {
        this.value = value;
    }

    @Override
    public MethodTypeE value() {
        return value;
    }

}
