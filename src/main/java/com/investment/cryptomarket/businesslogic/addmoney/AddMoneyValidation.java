package com.investment.cryptomarket.businesslogic.addmoney;

import com.investment.cryptomarket.businesslogic.Errors;

import java.util.List;

public interface AddMoneyValidation {
    List<Errors> validate( AddMoneyRequest request);
}
