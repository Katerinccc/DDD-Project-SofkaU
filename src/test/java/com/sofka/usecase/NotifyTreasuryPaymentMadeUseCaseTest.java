package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.generic.event.NotificationSent;
import com.sofka.domain.payment.event.PaymentMade;
import com.sofka.domain.payment.value.PaymentValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class NotifyTreasuryPaymentMadeUseCaseTest {

    private final String ROOT_ID = "4298Pñly7G";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyTreasuryPaymentMadeUseCaseTest() {

        PaymentMade domainEvent = new PaymentMade(
                new CreditID("125796pk97g"),
                new PaymentValue(470000)
        );
        domainEvent.setAggregateRootId(ROOT_ID);

        var useCase = new NotifyTreasuryPaymentMadeUseCase();

        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(domainEvent));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(domainEvent))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong sending the message."))
                .getDomainEvents();

        NotificationSent responseEvent = (NotificationSent) events.get(0);

        Assertions.assertEquals("The payment of the credit with ID 125796pk97g was made successfully.",
                responseEvent.getMessage());
        Mockito.verify(repository).getEventsBy(ROOT_ID);
    }
}