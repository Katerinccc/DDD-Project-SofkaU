package com.sofka.domain.customer;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.customer.event.AddressAdded;
import com.sofka.domain.customer.event.AddressCityUpdated;
import com.sofka.domain.customer.event.AddressNomenclatureUpdated;
import com.sofka.domain.customer.event.CustomerCreated;
import com.sofka.domain.customer.event.CustomerMessageSent;
import com.sofka.domain.customer.event.ReferenceAdded;
import com.sofka.domain.customer.event.ReferenceDeleted;
import com.sofka.domain.customer.event.ReferencePhoneNumberUpdated;
import com.sofka.domain.customer.value.AddressID;
import com.sofka.domain.customer.value.City;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.customer.value.Nomenclature;
import com.sofka.domain.customer.value.ReferenceID;
import com.sofka.domain.customer.value.Relationship;
import com.sofka.domain.generic.value.FullName;
import com.sofka.domain.generic.value.PhoneNumber;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Customer extends AggregateEvent<CustomerID> {

    protected FullName fullName;
    protected PhoneNumber phoneNumber;
    protected List<Address> addresses;
    protected List<Reference> references;

    private Customer(CustomerID customerID) {
        super(customerID);
        subscribe(new CustomerChange(this));
    }

    public static Customer from(CustomerID customerID, List<DomainEvent> events){
        Customer customer = new Customer(customerID);
        events.forEach(event -> customer.applyEvent(event));
        return customer;
    }

    public Optional<Reference> getReferenceById(ReferenceID referenceID){
        return references.stream().filter(reference -> reference.identity().equals(referenceID)).findFirst();
    }

    public Optional<Address> getAddressById(AddressID addressID){
        return addresses.stream().filter(address -> address.identity().equals(addressID)).findFirst();
    }

    public Customer(CustomerID entityId, FullName fullName, PhoneNumber phoneNumber){
        super(entityId);
        appendChange(new CustomerCreated(fullName, phoneNumber)).apply();
    }

    public void addAddress(AddressID entityId, Nomenclature nomenclature, City city) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nomenclature);
        Objects.requireNonNull(city);
        appendChange(new AddressAdded(entityId, nomenclature, city)).apply();
    }

    public void addRefence(ReferenceID entityId, FullName name, Relationship relationship, PhoneNumber phoneNumber) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(relationship);
        Objects.requireNonNull(phoneNumber);
        appendChange(new ReferenceAdded(entityId, name, relationship, phoneNumber));
    }

    public void deleteReference(ReferenceID entityId) {
        Objects.requireNonNull(entityId);
        appendChange(new ReferenceDeleted(entityId)).apply();
    }

    public void sendTextMessageToCustomer(String message){
        Objects.requireNonNull(message);
        appendChange(new CustomerMessageSent(message)).apply();
    }

    public void updateAddressNomenclature(AddressID entityId, Nomenclature nomenclature){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nomenclature);
        appendChange(new AddressNomenclatureUpdated(entityId, nomenclature)).apply();
    }

    public void updateAddressCity(AddressID entityId, City city){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(city);
        appendChange(new AddressCityUpdated(entityId, city)).apply();
    }

    public void updateReferencePhoneNumber(ReferenceID entityId, PhoneNumber phoneNumber){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(phoneNumber);
        appendChange(new ReferencePhoneNumberUpdated(entityId, phoneNumber)).apply();
    }

}
