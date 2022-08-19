package com.sofka.domain.credit.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.credit.value.Price;
import com.sofka.domain.credit.value.ProductID;

public class UpdatePrice extends Command {

    private final CreditID creditID;
    private final ProductID entityID;
    private final Price price;

    public UpdatePrice(CreditID creditID, ProductID entityID, Price price) {
        this.creditID = creditID;
        this.entityID = entityID;
        this.price = price;
    }

    public CreditID getCreditID() {
        return creditID;
    }

    public ProductID getEntityID() {
        return entityID;
    }

    public Price getPrice() {
        return price;
    }
}
