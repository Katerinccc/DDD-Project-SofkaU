package com.sofka.domain.payment;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.payment.event.PaymentMade;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentValue;
import java.util.List;

public class Payment extends AggregateEvent<PaymentID> {

    protected CreditID creditID;
    protected PaymentValue paymentValue;
    protected PaymentMethod paymentMethod;
    protected PaymentPlace paymentPlace;

    private Payment(PaymentID paymentID) {
        super(paymentID);
        subscribe(new PaymentChange(this));
    }

    public static Payment from(PaymentID paymentID, List<DomainEvent> events){
        Payment payment = new Payment(paymentID);
        events.forEach(event -> payment.applyEvent(event));
        return payment;
    }

    public Payment(PaymentID paymentID, CreditID creditID, PaymentValue paymentValue){
        super(paymentID);
        appendChange(new PaymentMade(creditID, paymentValue)).apply();
    }

}
