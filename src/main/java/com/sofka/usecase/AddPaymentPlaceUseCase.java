package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.payment.Payment;
import com.sofka.domain.payment.command.AddPaymentPlace;

public class AddPaymentPlaceUseCase extends UseCase<RequestCommand<AddPaymentPlace>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPaymentPlace> AddPaymentPlaceRequestCommand) {

        var command = AddPaymentPlaceRequestCommand.getCommand();
        var payment = Payment.from(command.getPaymentID(),
                retrieveEvents(command.getPaymentID().value()));

        payment.addPaymentPlace(command.getEntityId(), command.getPlaceType(), command.getLocation());
        emit().onResponse(new ResponseEvents(payment.getUncommittedChanges()));

    }
}
