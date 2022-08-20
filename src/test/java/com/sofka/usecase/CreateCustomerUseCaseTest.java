package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.customer.command.CreateCustomer;
import com.sofka.domain.customer.event.CustomerCreated;
import com.sofka.domain.generic.value.FullName;
import com.sofka.domain.generic.value.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateCustomerUseCaseTest {

    @Test
    void createCustomerUseCaseTest() {

        var command = new CreateCustomer(new FullName("Katerin Calderon"), new PhoneNumber("3127595517"));
        var useCase = new CreateCustomerUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong creating the customer."))
                .getDomainEvents();

        CustomerCreated event = (CustomerCreated) events.get(0);

        Assertions.assertEquals(command.getPhoneNumber().value(), event.getPhoneNumber().value());

    }

}