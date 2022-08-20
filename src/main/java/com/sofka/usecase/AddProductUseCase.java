package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.credit.Credit;
import com.sofka.domain.credit.command.AddProduct;

public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddProduct> addProductRequestCommand) {

        var command = addProductRequestCommand.getCommand();
        var credit = Credit.from(command.getCreditID(), retrieveEvents(command.getCreditID().value()));

        credit.addProduct(command.getproductID(), command.getProductName(), command.getPrice());

        emit().onResponse(new ResponseEvents(credit.getUncommittedChanges()));

    }
}
