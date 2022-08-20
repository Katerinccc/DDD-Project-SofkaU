package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.payment.Payment;
import com.sofka.domain.payment.command.MakePayment;

public class MakePaymentUseCase extends UseCase<RequestCommand<MakePayment>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<MakePayment> makePaymentRequestCommand) {

        var command = makePaymentRequestCommand.getCommand();
        var payment = new Payment(
                command.getPaymentID(),
                command.getCreditID(),
                command.getPaymentValue()
        );

        emit().onResponse(new ResponseEvents(payment.getUncommittedChanges()));

    }
}
