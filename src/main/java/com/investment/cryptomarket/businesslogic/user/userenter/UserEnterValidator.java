package com.investment.cryptomarket.businesslogic.user.userenter;

import com.investment.cryptomarket.businesslogic.Errors;

import java.util.List;

public interface UserEnterValidator {
    List<Errors> validate(UserEnterRequest request);
}
