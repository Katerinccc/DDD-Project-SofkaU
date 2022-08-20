package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.credit.command.CreateCredit;
import com.sofka.domain.credit.event.CreditCreated;
import com.sofka.domain.credit.value.CreditValue;
import com.sofka.domain.customer.value.CustomerID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateCreditUseCaseTest {

    @Test
    void createCreditUseCaseTest(){

        var command = new CreateCredit(new CustomerID("7596km12"), new CreditValue(1700000));
        var useCase = new CreateCreditUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong creating the credit."))
                .getDomainEvents();

        CreditCreated event = (CreditCreated) events.get(0);

        Assertions.assertEquals(command.getCreditValue().value(), event.getCreditValue().value());

    }


}