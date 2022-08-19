package com.sofka.domain.credit;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.credit.value.StoreAddress;
import com.sofka.domain.credit.value.StoreID;
import com.sofka.domain.credit.value.StoreName;
import java.util.Objects;

public class Store extends Entity<StoreID> {

    private StoreName storeName;
    private StoreAddress storeAddress;

    public Store(StoreID entityId, StoreName storeName, StoreAddress storeAddress) {
        super(entityId);
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }

    public void updateStoreName(StoreName storeName){
        this.storeName = Objects.requireNonNull(storeName);
    }

    public void updateStoreAddress(StoreAddress storeAddress){
        this.storeAddress = Objects.requireNonNull(storeAddress);
    }

    public StoreName storeName() {
        return storeName;
    }

    public StoreAddress storeAddress() {
        return storeAddress;
    }
}
