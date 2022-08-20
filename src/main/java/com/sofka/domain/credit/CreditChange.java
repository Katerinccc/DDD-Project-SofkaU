package com.sofka.domain.credit;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.credit.event.CreditCreated;
import com.sofka.domain.credit.event.ProductAdded;
import com.sofka.domain.credit.event.StoreAdded;

import java.util.ArrayList;
import java.util.List;

public class CreditChange extends EventChange {

    public CreditChange(Credit credit){

        apply((CreditCreated event) ->{
            credit.creditValue = event.getCreditValue();
            credit.customerID = event.geCustomerID();
            credit.products = new ArrayList<>();
        });

        apply((ProductAdded event) -> {
            List<Product> products = credit.products;
            products.add(new Product(event.getproductId(), event.getProductName(), event.getPrice()));
        });

        apply((StoreAdded event) -> {
            credit.store = new Store(event.getStoreId(), event.getStoreName(), event.getStoreAddress());
        });

    }
}
