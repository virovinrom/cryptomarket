package com.investment.cryptomarket.businesslogic.addcrypto;

import com.investment.cryptomarket.businesslogic.Errors;

import java.util.List;

public interface AddCryptoValidator {
    List<Errors> validate(AddCryptoRequest request);
}
