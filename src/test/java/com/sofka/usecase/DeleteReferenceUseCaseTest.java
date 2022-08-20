package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.customer.command.DeleteReference;
import com.sofka.domain.customer.event.CustomerCreated;
import com.sofka.domain.customer.event.ReferenceDeleted;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.customer.value.ReferenceID;
import com.sofka.domain.generic.value.FullName;
import com.sofka.domain.generic.value.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class DeleteReferenceUseCaseTest {

    private final String ROOT_ID = "741potve45";

    @Mock
    private DomainEventRepository repository;

    @Test
    void deleteReferenceUseCaseTest(){

        CustomerCreated domainEvent = new CustomerCreated(
                new FullName("Stephany Yepes"),
                new PhoneNumber("3158963520")
        );
        domainEvent.setAggregateRootId(ROOT_ID);

        var command = new DeleteReference(new CustomerID(ROOT_ID),
                new ReferenceID("Ihy79MK75")
        );
        var useCase = new DeleteReferenceUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(domainEvent));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong deleting the reference."))
                .getDomainEvents();

        ReferenceDeleted event = (ReferenceDeleted) events.get(0);

        Assertions.assertEquals(command.getReferenceId().value(), event.getReferenceID().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}