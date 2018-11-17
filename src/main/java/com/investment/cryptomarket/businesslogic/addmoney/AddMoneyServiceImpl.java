package com.investment.cryptomarket.businesslogic.addmoney;

import com.investment.cryptomarket.businesslogic.Errors;
import com.investment.cryptomarket.businesslogic.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddMoneyServiceImpl implements AddMoneyService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private AddMoneyValidation validation;

    @Override
    public AddMoneyResponse add(AddMoneyRequest request) {
        List<Errors> validationErrors = validation.validate(request);
        if (!validationErrors.isEmpty()) {
            return new AddMoneyResponse(validationErrors);
        }
        request.getUser().setCount(request.getMoney());
        repository.save(request.getUser());
        return new AddMoneyResponse(request.getUser().getId());
    }
}
