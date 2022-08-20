package com.sofka.domain.customer.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.customer.value.AddressID;
import com.sofka.domain.customer.value.City;
import com.sofka.domain.customer.value.Nomenclature;

public class AddressAdded extends DomainEvent {

    private final AddressID addressID;
    private final Nomenclature nomenclature;
    private final City city;

    public AddressAdded(AddressID addressID, Nomenclature nomenclature, City city) {
        super("sofka.domain.customer.AddressAdded");
        this.addressID = addressID;
        this.nomenclature = nomenclature;
        this.city = city;
    }

    public AddressID getAddressID() {
        return addressID;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public City getCity() {
        return city;
    }
}
