package com.investment.cryptomarket.businesslogic.addcrypto;

import com.investment.cryptomarket.businesslogic.Errors;
import com.investment.cryptomarket.businesslogic.builders.crypto.Crypto;
import com.investment.cryptomarket.businesslogic.builders.user.User;
import com.investment.cryptomarket.businesslogic.database.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddCryptoValidatorImpl implements AddCryptoValidator {
    @Autowired
    private CryptoRepository cryptoRepository;

    @Override
    public List<Errors> validate(AddCryptoRequest request) {
        List<Errors> errors = new ArrayList<>();
        validateDuplicateCrypto(request.getTitle()).ifPresent(errors::add);
        return errors;
    }

    private Optional<Errors> validateDuplicateCrypto(String crypto) {
        if (crypto != null && !crypto.isEmpty()) {
            Optional<Crypto> cryptoOut = cryptoRepository.findByTitle(crypto);
            if (cryptoOut.isPresent()) {
                return Optional.of(new Errors("crypto", "Must not be repeated"));
            }
        }
        return Optional.empty();
    }
}
