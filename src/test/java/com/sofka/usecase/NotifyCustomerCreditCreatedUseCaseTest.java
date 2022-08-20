package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.credit.event.CreditCreated;
import com.sofka.domain.credit.value.CreditValue;
import com.sofka.domain.customer.event.CustomerMessageSent;
import com.sofka.domain.customer.value.CustomerID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class NotifyCustomerCreditCreatedUseCaseTest {

    private final String ROOT_ID = "5239Lñp0H6f";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyCustomerCreditCreatedUseCaseTest() {

        CreditCreated domainEvent = new CreditCreated(new CustomerID("7418poU7B"), new CreditValue(170000));
        domainEvent.setAggregateRootId(ROOT_ID);

        var useCase = new NotifyCustomerCreditCreatedUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(domainEvent));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(domainEvent))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong sending the message."))
                .getDomainEvents();

        CustomerMessageSent responseEvent = (CustomerMessageSent) events.get(0);

        Assertions.assertEquals("The credit with ID 5239Lñp0H6f was generated successfully",
                responseEvent.getMessage());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}