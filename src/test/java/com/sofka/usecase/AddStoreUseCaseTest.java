package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.credit.command.AddStore;
import com.sofka.domain.credit.event.CreditCreated;
import com.sofka.domain.credit.event.ProductAdded;
import com.sofka.domain.credit.event.StoreAdded;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.credit.value.CreditValue;
import com.sofka.domain.credit.value.StoreAddress;
import com.sofka.domain.credit.value.StoreID;
import com.sofka.domain.credit.value.StoreName;
import com.sofka.domain.customer.value.CustomerID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddStoreUseCaseTest {

    private final String ROOT_ID = "7896plm6yf4";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addStoreUseCaseTest(){

        CreditCreated domainEvent = new CreditCreated(new CustomerID("8965m4dc"), new CreditValue(720000));
        domainEvent.setAggregateRootId(ROOT_ID);

        var command = new AddStore(
                new CreditID(ROOT_ID),
                new StoreID("iggsyTGV76"),
                new StoreName("Mayorca"),
                new StoreAddress("Calle 76 # 18-90")
        );
        var useCase = new AddStoreUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(domainEvent));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding the store."))
                .getDomainEvents();

        StoreAdded event = (StoreAdded) events.get(0);

        Assertions.assertEquals(command.getStoreAddress().value(), event.getStoreAddress().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}