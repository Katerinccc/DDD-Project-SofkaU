package com.sofka.domain.credit;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.credit.event.CreditCreated;
import java.util.ArrayList;

public class CreditChange extends EventChange {

    public CreditChange(Credit credit){

        apply((CreditCreated event) ->{
            credit.creditValue = event.getCreditValue();
            credit.customerID = event.geCustomerID();
            credit.products = new ArrayList<>();
        });


    }

}
