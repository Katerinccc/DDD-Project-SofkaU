package com.sofka.domain.credit.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.StoreAddress;
import com.sofka.domain.credit.value.StoreID;
import com.sofka.domain.credit.value.StoreName;

public class StoreAdded extends DomainEvent {

    private final StoreID storeId;
    private final StoreAddress storeAddress;
    private final StoreName storeName;

    public StoreAdded(StoreID storeId, StoreAddress storeAddress, StoreName storeName) {
        super("sofka.domain.credit.StoreAdded");
        this.storeId = storeId;
        this.storeAddress = storeAddress;
        this.storeName = storeName;
    }

    public StoreID getStoreId() {
        return storeId;
    }

    public StoreAddress getStoreAddress() {
        return storeAddress;
    }

    public StoreName getStoreName() {
        return storeName;
    }
}
