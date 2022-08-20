package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.credit.Credit;
import com.sofka.domain.credit.event.CreditCreated;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.customer.Customer;
import com.sofka.domain.customer.value.CustomerID;

public class NotifyCustomerCreditCreatedUseCase extends UseCase<TriggeredEvent<CreditCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CreditCreated> creditCreatedTriggeredEvent) {

        var event = creditCreatedTriggeredEvent.getDomainEvent();
//        var credit = Credit.from(CreditID.of(event.aggregateRootId()), this.retrieveEvents());
        var customer = Customer.from(CustomerID.of(event.aggregateRootId()), this.retrieveEvents());
        var creditId = CreditID.of(event.aggregateRootId());

        customer.sendTextMessageToCustomer("The credit with ID " + creditId + " was generated successfully");

        emit().onResponse(new ResponseEvents(customer.getUncommittedChanges()));

    }
}
