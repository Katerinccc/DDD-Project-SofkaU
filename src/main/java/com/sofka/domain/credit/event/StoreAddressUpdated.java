package com.sofka.domain.credit.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.StoreAddress;
import com.sofka.domain.credit.value.StoreID;

public class StoreAddressUpdated extends DomainEvent {

    private final StoreID storeId;
    private final StoreAddress storeAddress;

    public StoreAddressUpdated(StoreID storeId, StoreAddress storeAddress) {
        super("sofka.domain.credit.StoreAddressUpdated");
        this.storeId = storeId;
        this.storeAddress = storeAddress;
    }

    public StoreID getStoreId() {
        return storeId;
    }

    public StoreAddress getStoreAddress() {
        return storeAddress;
    }
}
