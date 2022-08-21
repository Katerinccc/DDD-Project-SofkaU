package com.sofka.domain.payment;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.payment.event.PaymentMade;
import com.sofka.domain.payment.event.PaymentMethodAdded;
import com.sofka.domain.payment.event.PaymentMethodDeleted;
import com.sofka.domain.payment.event.PaymentPlaceAdded;
import com.sofka.domain.payment.event.PaymentTypeUpdated;
import com.sofka.domain.payment.event.PlaceLocationUpdated;
import com.sofka.domain.payment.event.PlaceTypeUpdated;
import com.sofka.domain.payment.value.PaymentMethodID;

public class PaymentChange extends EventChange {

    public PaymentChange(Payment payment){

        apply((PaymentMade event) ->{
            payment.creditID = event.getCreditID();
            payment.paymentValue = event.getPaymentValue();
        });

        apply((PaymentMethodAdded event) -> payment.paymentMethod = new PaymentMethod(
                event.getPaymentMethodID(),
                event.getPaymentType(),
                event.getDescription()
        ));

        apply((PaymentPlaceAdded event) -> {
            payment.paymentPlace = new PaymentPlace(
                    event.getPaymentPlaceID(),
                    event.getPlaceType(),
                    event.getLocation()
            );
        });

        apply((PaymentMethodDeleted event) -> {
            PaymentMethodID id = event.getPaymentMethodID();
            System.out.println("Payment method with ID: " + id + " was deleted successfully");
        });

        apply((PaymentTypeUpdated event) -> {
            var paymentMethod = payment.paymentMethod;
            paymentMethod.updatePaymentType(event.getPaymentType());
        });

        apply((PlaceLocationUpdated event) -> {
            var paymentPlace = payment.paymentPlace;
            paymentPlace.updateLocation(event.getLocation());
        });

        apply((PlaceTypeUpdated event) -> {
            var paymentPlace = payment.paymentPlace;
            paymentPlace.updatePlaceType(event.getPlaceType());
        });

    }

}
