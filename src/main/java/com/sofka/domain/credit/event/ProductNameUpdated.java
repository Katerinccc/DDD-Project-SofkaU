package com.sofka.domain.credit.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.credit.value.ProductID;
import com.sofka.domain.credit.value.ProductName;

public class ProductNameUpdated extends DomainEvent {

    private final ProductID productId;
    private final ProductName productName;

    public ProductNameUpdated(String type, ProductID productId, ProductName productName) {
        super("sofka.domain.credit.ProductNameUpdated");
        this.productId = productId;
        this.productName = productName;
    }

    public ProductID getProductId() {
        return productId;
    }

    public ProductName getProductName() {
        return productName;
    }
}
