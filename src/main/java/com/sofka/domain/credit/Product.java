package com.sofka.domain.credit;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.credit.value.Price;
import com.sofka.domain.credit.value.ProductID;
import com.sofka.domain.credit.value.ProductName;
import java.util.Objects;

public class Product extends Entity<ProductID> {

    private ProductName productName;
    private Price price;

    public Product(ProductID entityId, ProductName productName, Price price) {
        super(entityId);
        this.productName = productName;
        this.price = price;
    }

    public void updatePrice(Price price){
        this.price = Objects.requireNonNull(price);
    }

    public void updateProductName(ProductName productName){
        this.productName = Objects.requireNonNull(productName);
    }

    public ProductName productName() {
        return productName;
    }

    public Price price() {
        return price;
    }
}
