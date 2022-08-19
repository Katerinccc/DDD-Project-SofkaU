package com.sofka.domain.customer.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.customer.value.AddressID;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.customer.value.Nomenclature;

public class UpdateAddressNomenclature extends Command {

    private final CustomerID customerId;
    private final AddressID entityId;
    private final Nomenclature nomenclature;

    public UpdateAddressNomenclature(CustomerID customerId, AddressID entityId, Nomenclature nomenclature) {
        this.customerId = customerId;
        this.entityId = entityId;
        this.nomenclature = nomenclature;
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
}
