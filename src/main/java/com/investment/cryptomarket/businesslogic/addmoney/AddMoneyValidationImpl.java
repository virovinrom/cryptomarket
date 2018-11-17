package com.investment.cryptomarket.businesslogic.addmoney;

import com.investment.cryptomarket.businesslogic.Errors;
import com.investment.cryptomarket.businesslogic.builders.user.User;
import com.investment.cryptomarket.businesslogic.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddMoneyValidationImpl implements AddMoneyValidation {
    @Autowired
    private UserRepository repository;

    @Override
    public List<Errors> validate(AddMoneyRequest request) {
        List<Errors> errors = new ArrayList<>();
        emptyMoneyValidation(request.getMoney()).ifPresent(errors::add);
        return errors;
    }

    public Optional<Errors> emptyMoneyValidation(Double money) {
        if (money.isNaN()) {
            return Optional.of(new Errors("money", "Must not be empty"));
        }
        return Optional.empty();
    }
}
