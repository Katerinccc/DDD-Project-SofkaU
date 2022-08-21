package com.sofka.domain.credit;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.credit.event.CreditCreated;
import com.sofka.domain.credit.event.ProductAdded;
import com.sofka.domain.credit.event.ProductNameUpdated;
import com.sofka.domain.credit.event.ProductPriceUpdated;
import com.sofka.domain.credit.event.StoreAdded;
import com.sofka.domain.credit.event.StoreAddressUpdated;
import com.sofka.domain.credit.event.StoreNameUpdated;
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

        apply((ProductNameUpdated event) -> {
            var product = credit.getProductById(
                    event.getProductId())
                    .orElseThrow(()->new IllegalArgumentException("The product ID is not valid"));
            product.updateProductName(event.getProductName());
        });

        apply((ProductPriceUpdated event) -> {
            var product = credit.getProductById(
                            event.getProductId())
                    .orElseThrow(()->new IllegalArgumentException("The product ID is not valid"));
            product.updatePrice(event.getPrice());
        });

        apply((StoreAddressUpdated event) -> {
            var store = credit.store;
            store.updateStoreAddress(event.getStoreAddress());
        });

        apply((StoreNameUpdated event) -> {
            var store = credit.store;
            store.updateStoreName(event.getStoreName());
        });

    }
}
