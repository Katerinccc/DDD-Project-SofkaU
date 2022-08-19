package com.sofka.domain.payment.value;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.validator.GenericValidator;

public class PaymentValue implements ValueObject<Integer> {

    private final Integer value;

    public PaymentValue(Integer value) {
        if (!GenericValidator.isInt(String.valueOf(value))){
            throw new IllegalArgumentException("The VO needs to be a number.");
        }
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

}
