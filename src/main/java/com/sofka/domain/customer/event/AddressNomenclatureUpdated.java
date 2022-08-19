package com.sofka.domain.customer.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.customer.value.AddressID;
import com.sofka.domain.customer.value.Nomenclature;

public class AddressNomenclatureUpdated extends DomainEvent {

    private final AddressID addressID;
    private final Nomenclature nomenclature;

    public AddressNomenclatureUpdated(AddressID addressID, Nomenclature nomenclature) {
        super("sofka.domain.customer.AddressNomenclatureUpdated");
        this.addressID = addressID;
        this.nomenclature = nomenclature;
    }

    public AddressID getAddressID() {
        return addressID;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }
}
