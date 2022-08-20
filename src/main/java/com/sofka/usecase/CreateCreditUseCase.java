package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.credit.Credit;
import com.sofka.domain.credit.command.CreateCredit;

public class CreateCreditUseCase extends UseCase<RequestCommand<CreateCredit>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCredit> createCreditRequestCommand) {

        var command = createCreditRequestCommand.getCommand();
        var credit = new Credit(
                command.getCreditID(),
                command.getCustomerID(),
                command.getCreditValue()
        );

        emit().onResponse(new ResponseEvents(credit.getUncommittedChanges()));
    }
}
