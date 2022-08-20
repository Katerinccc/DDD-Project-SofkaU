package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.payment.command.AddPaymentMethod;
import com.sofka.domain.payment.event.PaymentMade;
import com.sofka.domain.payment.event.PaymentMethodAdded;
import com.sofka.domain.payment.value.Description;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentMethodID;
import com.sofka.domain.payment.value.PaymentType;
import com.sofka.domain.payment.value.PaymentValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddPaymentMethodUseCaseTest {

    private final String ROOT_ID = "4298Pñly7G";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addPaymentMethodUseCaseTest(){

        PaymentMade domainEvent = new PaymentMade(
                new CreditID("125796pk97g"),
                new PaymentValue(470000)
        );
        domainEvent.setAggregateRootId(ROOT_ID);

        var command = new AddPaymentMethod(new PaymentID(ROOT_ID),
                new PaymentMethodID("963Lkiy7Y"),
                new PaymentType("Credit Card"),
                new Description("VISA")
        );
        var useCase = new AddPaymentMethodUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(domainEvent));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding the payment method."))
                .getDomainEvents();

        PaymentMethodAdded event = (PaymentMethodAdded) events.get(0);

        Assertions.assertEquals(command.getPaymentType().value(), event.getPaymentType().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}