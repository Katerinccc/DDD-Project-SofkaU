package com.sofka.domain.credit.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.credit.value.StoreAddress;
import com.sofka.domain.credit.value.StoreID;
import com.sofka.domain.credit.value.StoreName;

public class AddStore extends Command {

    private final CreditID creditID;
    private final StoreID entityID;
    private final StoreName storeName;
    private final StoreAddress storeAddress;

    public AddStore(CreditID creditID, StoreID entityID, StoreName storeName, StoreAddress storeAddress) {
        this.creditID = creditID;
        this.entityID = entityID;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }

    public CreditID getCreditID() {
        return creditID;
    }

    public StoreID getEntityID() {
        return entityID;
    }

    public StoreName getStoreName() {
        return storeName;
    }

    public StoreAddress getStoreAddress() {
        return storeAddress;
    }
}
