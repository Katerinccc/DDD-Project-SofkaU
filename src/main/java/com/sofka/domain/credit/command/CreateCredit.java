package com.sofka.domain.credit.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.credit.value.CreditID;
import com.sofka.domain.credit.value.CreditValue;
import com.sofka.domain.customer.value.CustomerID;

public class CreateCredit extends Command {

    private final CreditID creditID;
    private final CustomerID customerID;
    private final CreditValue creditValue;

    public CreateCredit(CustomerID customerID, CreditValue creditValue) {
        this.creditID = new CreditID();
        this.customerID = customerID;
        this.creditValue = creditValue;
    }

    public CreditID getCreditID() {
        return creditID;
    }

    public CustomerID getCustomerID() {
        return customerID;
    }

    public CreditValue getCreditValue() {
        return creditValue;
    }
}
