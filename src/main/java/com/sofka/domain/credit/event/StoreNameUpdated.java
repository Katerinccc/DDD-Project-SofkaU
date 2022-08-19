package com.sofka.domain.credit.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.StoreID;
import com.sofka.domain.credit.value.StoreName;

public class StoreNameUpdated extends DomainEvent {

    private final StoreID storeId;
    private final StoreName storeName;

    public StoreNameUpdated(StoreID storeId, StoreName storeName) {
        super("sofka.domain.credit.StoreNameUpdated");
        this.storeId = storeId;
        this.storeName = storeName;
    }

    public StoreID getStoreId() {
        return storeId;
    }

    public StoreName getStoreName() {
        return storeName;
    }
}
