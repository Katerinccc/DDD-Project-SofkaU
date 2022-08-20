package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.payment.Payment;
import com.sofka.domain.payment.event.PaymentMade;
import com.sofka.domain.payment.value.PaymentID;

public class NotifyTreasuryPaymentMadeUseCase extends UseCase<TriggeredEvent<PaymentMade>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<PaymentMade> paymentMadeTriggeredEvent) {

        var event = paymentMadeTriggeredEvent.getDomainEvent();
        var payment = Payment.from(PaymentID.of(event.aggregateRootId()), this.retrieveEvents());
        var creditId = event.getCreditID();

        payment.notifyTreasuryArea("The payment of the credit with ID " + creditId + " was made successfully.");

        emit().onResponse(new ResponseEvents(payment.getUncommittedChanges()));

    }
}
