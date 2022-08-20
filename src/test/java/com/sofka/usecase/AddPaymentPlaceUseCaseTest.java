package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.payment.command.AddPaymentPlace;
import com.sofka.domain.payment.event.PaymentMade;
import com.sofka.domain.payment.event.PaymentPlaceAdded;
import com.sofka.domain.payment.value.Location;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentPlaceID;
import com.sofka.domain.payment.value.PaymentValue;
import com.sofka.domain.payment.value.PlaceType;
import com.sofka.domain.payment.value.PlaceTypeE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddPaymentPlaceUseCaseTest {

    private final String ROOT_ID = "4298Pñly7G";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addPaymentPlaceUseCaseTest(){

        PaymentMade domainEvent = new PaymentMade(
                new CreditID("125796pk97g"),
                new PaymentValue(470000)
        );
        domainEvent.setAggregateRootId(ROOT_ID);

        var command = new AddPaymentPlace(new PaymentID(ROOT_ID),
                new PaymentPlaceID("2569Ñlki9Y"),
                new PlaceType(PlaceTypeE.PSE),
                new Location("Digital")
        );
        var useCase = new AddPaymentPlaceUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(domainEvent));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong adding the payment place."))
                .getDomainEvents();

        PaymentPlaceAdded event = (PaymentPlaceAdded) events.get(0);

        Assertions.assertEquals(command.getPlaceType().value(), event.getPlaceType().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}