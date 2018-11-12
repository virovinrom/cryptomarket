package com.investment.cryptomarket.businesslogic.userregistration;

import com.investment.cryptomarket.businesslogic.Errors;

import java.util.List;

public interface UserRegistrationValidator {
    List<Errors> validate(UserRegistrationRequest request);
}
