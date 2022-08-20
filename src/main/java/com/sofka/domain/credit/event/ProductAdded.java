package com.sofka.domain.credit.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.Price;
import com.sofka.domain.credit.value.ProductID;
import com.sofka.domain.credit.value.ProductName;

public class ProductAdded extends DomainEvent {

    private final ProductID productId;
    private final ProductName productName;
    private final Price price;

    public ProductAdded(ProductID productId, ProductName productName, Price price) {
        super("sofka.domain.credit.ProductAdded");
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public ProductID getproductId() {
        return productId;
    }

    public ProductName getProductName() {
        return productName;
    }

    public Price getPrice() {
        return price;
    }
}
