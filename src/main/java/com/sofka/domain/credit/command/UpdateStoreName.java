package com.sofka.domain.credit.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.credit.value.StoreID;
import com.sofka.domain.credit.value.StoreName;

public class UpdateStoreName extends Command {

    private final CreditID creditID;
    private final StoreID entityID;
    private final StoreName storeName;

    public UpdateStoreName(CreditID creditID, StoreID entityID, StoreName storeName) {
        this.creditID = creditID;
        this.entityID = entityID;
        this.storeName = storeName;
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
}
