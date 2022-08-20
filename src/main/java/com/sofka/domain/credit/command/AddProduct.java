package com.sofka.domain.credit.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.credit.value.Price;
import com.sofka.domain.credit.value.ProductID;
import com.sofka.domain.credit.value.ProductName;

public class AddProduct extends Command {

    private final CreditID creditID;
    private final ProductID productID;
    private final ProductName productName;
    private final Price price;

    public AddProduct(CreditID creditID, ProductID productID, ProductName productName, Price price) {
        this.creditID = creditID;
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }

    public CreditID getCreditID() {
        return creditID;
    }

    public ProductID getproductID() {
        return productID;
    }

    public ProductName getProductName() {
        return productName;
    }

    public Price getPrice() {
        return price;
    }
}
