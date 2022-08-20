package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.payment.command.MakePayment;
import com.sofka.domain.payment.event.PaymentMade;
import com.sofka.domain.payment.value.PaymentValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MakePaymentUseCaseTest {

    @Test
    void makePaymentUseCaseTest(){

        var command = new MakePayment(new CreditID("123789Kl71"), new PaymentValue(500000));
        var useCase = new MakePaymentUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong making the payment."))
                .getDomainEvents();

        PaymentMade event = (PaymentMade) events.get(0);

        Assertions.assertEquals(command.getPaymentValue().value(), event.getPaymentValue().value());

    }

}