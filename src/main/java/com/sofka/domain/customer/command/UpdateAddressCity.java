package com.sofka.domain.customer.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.customer.value.AddressID;
import com.sofka.domain.customer.value.City;
import com.sofka.domain.customer.value.CustomerID;

public class UpdateAddressCity extends Command {

    private final CustomerID customerId;
    private final AddressID entityId;
    private final City city;

    public UpdateAddressCity(CustomerID customerId, AddressID entityId, City city) {
        this.customerId = customerId;
        this.entityId = entityId;
        this.city = city;
    }

    public CustomerID getCustomerId() {
        return customerId;
    }

    public AddressID getEntityId() {
        return entityId;
    }

    public City getCity() {
        return city;
    }
}
