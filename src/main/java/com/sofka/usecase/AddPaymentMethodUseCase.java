package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.payment.Payment;
import com.sofka.domain.payment.command.AddPaymentMethod;

public class AddPaymentMethodUseCase extends UseCase<RequestCommand<AddPaymentMethod>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddPaymentMethod> AddPaymentMethodRequestCommand) {

        var command = AddPaymentMethodRequestCommand.getCommand();
        var payment = Payment.from(command.getPaymentID(),
                retrieveEvents(command.getPaymentID().value()));

        payment.addPaymentMethod(command.getEntityId(), command.getPaymentType(), command.getDescription());

        emit().onResponse(new ResponseEvents(payment.getUncommittedChanges()));

    }

}
