package com.sofka.domain.credit;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.event.CreditCreated;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.credit.value.CreditValue;
import com.sofka.domain.customer.value.CustomerID;
import java.util.List;

public class Credit extends AggregateEvent<CreditID> {

    protected CustomerID customerID;
    protected CreditValue creditValue;
    protected Store store;
    protected List<Product> products;

    private Credit(CreditID entityId) {
        super(entityId);
        subscribe(new CreditChange(this));
    }

    public static Credit from(CreditID creditID, List<DomainEvent> events){
        Credit credit = new Credit(creditID);
        events.forEach(event -> credit.applyEvent(event));
        return credit;
    }

    public Credit(CreditID entityId, CustomerID customerID, CreditValue creditValue){
        super(entityId);
        appendChange(new CreditCreated(customerID, creditValue)).apply();
    }

}
