package com.sofka.domain.customer;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.customer.event.AddressAdded;
import com.sofka.domain.customer.event.AddressCityUpdated;
import com.sofka.domain.customer.event.AddressNomenclatureUpdated;
import com.sofka.domain.customer.event.CustomerCreated;
import com.sofka.domain.customer.event.ReferenceAdded;
import com.sofka.domain.customer.event.ReferenceDeleted;
import com.sofka.domain.customer.event.ReferencePhoneNumberUpdated;

import java.util.ArrayList;
import java.util.List;

public class CustomerChange extends EventChange {

    public CustomerChange(Customer customer){

        apply((CustomerCreated event) -> {
            customer.fullName = event.getFullName();
            customer.phoneNumber = event.getPhoneNumber();
            customer.addresses = new ArrayList<>();
            customer.references = new ArrayList<>();
        });

        apply((AddressAdded event) -> {
            List<Address> addresses = customer.addresses;
            addresses.add(new Address(event.getAddressID(), event.getNomenclature(), event.getCity()));
        });

        apply((ReferenceAdded event) -> {
            List<Reference> references = customer.references;
            references.add(new Reference(event.getReferenceID(),
                    event.getFullName(),
                    event.getRelationship(),
                    event.getPhoneNumber())
            );
        });

        apply((ReferenceDeleted event) -> {
            List<Reference> references = customer.references;
            references.remove(event.getReferenceID());
        });

        apply((AddressNomenclatureUpdated event) -> {
            var address = customer.getAddressById(
                            event.getAddressID())
                            .orElseThrow(()->new IllegalArgumentException("The address ID is not valid"));
            address.updateNomenclature(event.getNomenclature());
        });

        apply((AddressCityUpdated event) -> {
            var address = customer.getAddressById(
                            event.getAddressID())
                    .orElseThrow(()->new IllegalArgumentException("The address ID is not valid"));
            address.updateCity(event.getCity());
        });

        apply((ReferencePhoneNumberUpdated event) -> {
            var reference = customer.getReferenceById(
                            event.getReferenceID())
                    .orElseThrow(()->new IllegalArgumentException("The reference ID is not valid"));
            reference.updatePhoneNumber(event.getPhoneNumber());
        });

    }

}
