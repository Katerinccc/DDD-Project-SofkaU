package com.sofka.domain.customer;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.customer.value.AddressID;
import com.sofka.domain.customer.value.City;
import com.sofka.domain.customer.value.Nomenclature;
import java.util.Objects;

public class Address extends Entity<AddressID> {

    private Nomenclature nomenclature;
    private City city;

    public Address(AddressID entityId, Nomenclature nomenclature, City city) {
        super(entityId);
        this.nomenclature = nomenclature;
        this.city = city;
    }

    public void updateNomenclature(Nomenclature nomenclature){
        this.nomenclature = Objects.requireNonNull(nomenclature);
    }

    public void updateCity(City city){
        this.city = Objects.requireNonNull(city);
    }

    public Nomenclature nomenclature() {
        return nomenclature;
    }

    public City city() {
        return city;
    }
}
