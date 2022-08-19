package com.sofka.domain.credit.value;

import co.com.sofka.domain.generic.Identity;

public class CreditID extends Identity {

    public CreditID() {

    }

    public CreditID(String id) {
        super(id);
    }

    public static CreditID of (String id){
        return new CreditID(id);
    }

}
