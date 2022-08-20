package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.credit.Credit;
import com.sofka.domain.credit.command.AddStore;

public class AddStoreUseCase extends UseCase<RequestCommand<AddStore>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddStore> addStoreRequestCommand) {

        var command = addStoreRequestCommand.getCommand();
        var credit = Credit.from(command.getCreditID(), retrieveEvents(command.getCreditID().value()));

        credit.addStore(command.getEntityID(), command.getStoreAddress(), command.getStoreName());

        emit().onResponse(new ResponseEvents(credit.getUncommittedChanges()));

    }
}
