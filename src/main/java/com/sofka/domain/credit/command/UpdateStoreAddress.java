package com.sofka.domain.credit.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.credit.value.StoreAddress;
import com.sofka.domain.credit.value.StoreID;

public class UpdateStoreAddress extends Command {

    private final CreditID creditID;
    private final StoreID entityID;
    private final StoreAddress storeAddress;

    public UpdateStoreAddress(CreditID creditID, StoreID entityID, StoreAddress storeAddress) {
        this.creditID = creditID;
        this.entityID = entityID;
        this.storeAddress = storeAddress;
    }

    public CreditID getCreditID() {
        return creditID;
    }

    public StoreID getEntityID() {
        return entityID;
    }

    public StoreAddress getStoreAddress() {
        return storeAddress;
    }
}
