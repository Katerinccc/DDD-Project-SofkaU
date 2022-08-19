package com.sofka.domain.customer.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.customer.value.AddressID;
import com.sofka.domain.customer.value.City;

public class AddressCityUpdated extends DomainEvent {

    private final AddressID addressID;
    private final City city;

    public AddressCityUpdated(String type, AddressID addressID, City city) {
        super("sofka.domain.customer.AddressCityUpdated");
        this.addressID = addressID;
        this.city = city;
    }

    public AddressID getAddressID() {
        return addressID;
    }

    public City getCity() {
        return city;
    }
}
