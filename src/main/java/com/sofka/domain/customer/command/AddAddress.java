package com.sofka.domain.customer.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.customer.value.AddressID;
import com.sofka.domain.customer.value.City;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.customer.value.Nomenclature;

public class AddAddress extends Command {

    private final CustomerID customerId;
    private final AddressID entityId;
    private final Nomenclature nomenclature;
    private final City city;

    public AddAddress(CustomerID customerId, AddressID entityId, Nomenclature nomenclature, City city) {
        this.customerId = customerId;
        this.entityId = entityId;
        this.nomenclature = nomenclature;
        this.city = city;
    }

    public CustomerID getCustomerId() {
        return customerId;
    }

    public AddressID getEntityId() {
        return entityId;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public City getCity() {
        return city;
    }
}
