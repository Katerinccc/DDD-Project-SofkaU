package com.sofka.domain.customer.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.customer.value.CustomerID;
import com.sofka.domain.customer.value.ReferenceID;

public class DeleteReference extends Command {

    private final CustomerID customerId;
    private final ReferenceID referenceId;

    public DeleteReference(CustomerID customerId, ReferenceID referenceId) {
        this.customerId = customerId;
        this.referenceId = referenceId;
    }

    public CustomerID getCustomerId() {
        return customerId;
    }

    public ReferenceID getReferenceId() {
        return referenceId;
    }
}
