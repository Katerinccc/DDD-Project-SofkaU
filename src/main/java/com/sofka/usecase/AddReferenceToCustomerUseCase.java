package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.customer.Customer;
import com.sofka.domain.customer.command.AddReference;

public class AddReferenceToCustomerUseCase extends UseCase<RequestCommand<AddReference>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddReference> AddReferenceRequestCommand) {

        var command = AddReferenceRequestCommand.getCommand();
        var customer = Customer.from(command.getCustomerId(),
                retrieveEvents(command.getCustomerId().value()));

        customer.addRefence(command.getReferenceId(),
                command.getFullName(),
                command.getRelationship(),
                command.getPhoneNumber()
        );

        emit().onResponse(new ResponseEvents(customer.getUncommittedChanges()));

    }
}
