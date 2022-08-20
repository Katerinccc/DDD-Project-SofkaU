package com.sofka.domain.payment;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.generic.event.NotificationSent;
import com.sofka.domain.payment.event.PaymentMade;
import com.sofka.domain.payment.event.PaymentMethodAdded;
import com.sofka.domain.payment.event.PaymentPlaceAdded;
import com.sofka.domain.payment.value.Description;
import com.sofka.domain.payment.value.Location;
import com.sofka.domain.payment.value.PaymentID;
import com.sofka.domain.payment.value.PaymentMethodID;
import com.sofka.domain.payment.value.PaymentPlaceID;
import com.sofka.domain.payment.value.PaymentType;
import com.sofka.domain.payment.value.PaymentValue;
import com.sofka.domain.payment.value.PlaceType;

import java.util.List;
import java.util.Objects;

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

    public void addPaymentMethod(PaymentMethodID entityId, PaymentType paymentType, Description description) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(paymentType);
        Objects.requireNonNull(description);
        appendChange(new PaymentMethodAdded(entityId, paymentType, description)).apply();
    }

    public void addPaymentPlace(PaymentPlaceID entityId, PlaceType placeType, Location location) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(placeType);
        Objects.requireNonNull(location);
        appendChange(new PaymentPlaceAdded(entityId, placeType, location)).apply();
    }

    public void notifyTreasuryArea(String message) {
        Objects.requireNonNull(message);
        appendChange(new NotificationSent(message)).apply();
    }
}
