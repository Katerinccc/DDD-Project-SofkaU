package com.sofka.domain.credit.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.Price;
import com.sofka.domain.credit.value.ProductID;

public class ProductPriceUpdated extends DomainEvent {

    private final ProductID productId;
    private final Price price;

    public ProductPriceUpdated(String type, ProductID productId, Price price) {
        super("sofka.domain.credit.ProductPriceUpdated");
        this.productId = productId;
        this.price = price;
    }

    public ProductID getProductId() {
        return productId;
    }

    public Price getPrice() {
        return price;
    }
}
