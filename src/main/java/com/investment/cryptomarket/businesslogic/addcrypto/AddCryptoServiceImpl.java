package com.investment.cryptomarket.businesslogic.addcrypto;

import com.investment.cryptomarket.businesslogic.Errors;
import com.investment.cryptomarket.businesslogic.builders.crypto.Crypto;

import com.investment.cryptomarket.businesslogic.database.CryptoRepository;
import com.investment.cryptomarket.businesslogic.user.userregistration.UserRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.investment.cryptomarket.businesslogic.builders.crypto.CryptoBuilder.createCrypto;

@Component
public class AddCryptoServiceImpl implements AddCryptoService {
    @Autowired
    private AddCryptoValidator validator;
    @Autowired
    private CryptoRepository repository;
    @Override
    public AddCryptoResponse add(AddCryptoRequest request) {

        List<Errors> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            return new AddCryptoResponse(validationErrors);
        }


      Crypto crypto = createCrypto()
              .withTitle(request.getTitle())
              .withCurrensy(request.getCurrency())
              .build();


        repository.save(crypto);

        return new AddCryptoResponse(crypto.getId());
    }
}
