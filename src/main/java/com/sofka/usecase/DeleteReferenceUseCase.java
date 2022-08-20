package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.customer.Customer;
import com.sofka.domain.customer.command.DeleteReference;

public class DeleteReferenceUseCase extends UseCase<RequestCommand<DeleteReference>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<DeleteReference> DeleteReferenceRequestCommand) {

        var command = DeleteReferenceRequestCommand.getCommand();
        var customer = Customer.from(command.getCustomerId(),
                retrieveEvents(command.getCustomerId().value()));

        customer.deleteReference(command.getReferenceId());

        emit().onResponse(new ResponseEvents(customer.getUncommittedChanges()));

    }
}
