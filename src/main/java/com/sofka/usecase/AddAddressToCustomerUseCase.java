package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.customer.Customer;
import com.sofka.domain.customer.command.AddAddress;

public class AddAddressToCustomerUseCase extends UseCase<RequestCommand<AddAddress>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddAddress> AddAddressRequestCommand) {

        var command = AddAddressRequestCommand.getCommand();
        var customer = Customer.from(command.getCustomerId(),
                retrieveEvents(command.getCustomerId().value()));

        customer.addAddress(command.getEntityId(), command.getNomenclature(), command.getCity());

        emit().onResponse(new ResponseEvents(customer.getUncommittedChanges()));

    }
}
