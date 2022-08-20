package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.customer.command.AddAddress;
import com.sofka.domain.customer.event.AddressAdded;
import com.sofka.domain.customer.event.CustomerCreated;
import com.sofka.domain.customer.value.AddressID;
import com.sofka.domain.customer.value.City;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.customer.value.Nomenclature;
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
class AddAddressToCustomerUseCaseTest {

    private final String ROOT_ID = "741potve45";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addAddressToCustomerUseCaseTest(){

        CustomerCreated domainEvent = new CustomerCreated(
                new FullName("Stephany Yepes"),
                new PhoneNumber("3158963520")
        );
        domainEvent.setAggregateRootId(ROOT_ID);

        var command = new AddAddress(new CustomerID(ROOT_ID),
                new AddressID("87123lju80"),
                new Nomenclature("Calle 87 # 10-15"),
                new City("Envigado")
        );
        var useCase = new AddAddressToCustomerUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(domainEvent));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding the address."))
                .getDomainEvents();

        AddressAdded event = (AddressAdded) events.get(0);

        Assertions.assertEquals(command.getCity().value(), event.getCity().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}