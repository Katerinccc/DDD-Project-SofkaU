package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.customer.Customer;
import com.sofka.domain.customer.command.CreateCustomer;

public class CreateCustomerUseCase extends UseCase<RequestCommand<CreateCustomer>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCustomer> createCustomerRequestCommand) {
        var command = createCustomerRequestCommand.getCommand();
        var customer = new Customer(
                command.getCustomerId(),
                command.getFullName(),
                command.getPhoneNumber()
        );

        emit().onResponse(new ResponseEvents(customer.getUncommittedChanges()));

    }
}
