package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.credit.command.AddProduct;
import com.sofka.domain.credit.event.CreditCreated;
import com.sofka.domain.credit.event.ProductAdded;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.credit.value.CreditValue;
import com.sofka.domain.credit.value.Price;
import com.sofka.domain.credit.value.ProductID;
import com.sofka.domain.credit.value.ProductName;
import com.sofka.domain.customer.value.CustomerID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddProductUseCaseTest {

    private final String ROOT_ID = "125796pk97g";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addProductUseCaseTest(){

        CreditCreated domainEvent = new CreditCreated(new CustomerID("85114ñkjh"), new CreditValue(1785000));
        domainEvent.setAggregateRootId(ROOT_ID);

        var command = new AddProduct(new CreditID(ROOT_ID),
                        new ProductID("65456487"),
                        new ProductName("Tablet"),
                        new Price(1785000)
        );
        var useCase = new AddProductUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(domainEvent));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding the product."))
                .getDomainEvents();

        ProductAdded event = (ProductAdded) events.get(0);

        Assertions.assertEquals(command.getProductName().value(), event.getProductName().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}