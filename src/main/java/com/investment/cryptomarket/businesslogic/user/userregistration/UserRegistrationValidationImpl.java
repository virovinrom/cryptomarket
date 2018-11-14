package com.investment.cryptomarket.businesslogic.user.userregistration;

import com.investment.cryptomarket.businesslogic.Errors;
import com.investment.cryptomarket.businesslogic.builders.user.User;
import com.investment.cryptomarket.businesslogic.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRegistrationValidationImpl implements UserRegistrationValidator {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Errors> validate(UserRegistrationRequest request) {
        List<Errors> errors = new ArrayList<>();
        validateLogin(request.getLogin()).ifPresent(errors::add);
        validateDuplicateLogin(request.getLogin()).ifPresent(errors::add);
        validatePassword(request.getPassword()).ifPresent(errors::add);
        return errors;
    }

    private Optional<Errors> validateLogin(String login) {
        if (login == null || login.isEmpty()) {
            return Optional.of(new Errors("login", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Errors> validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return Optional.of(new Errors("password", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Errors> validateDuplicateLogin(String login) {
        if (login != null && !login.isEmpty()) {
            Optional<User> userOpt = userRepository.findByLogin(login);
            if (userOpt.isPresent()) {
                return Optional.of(new Errors("login", "Must not be repeated"));
            }
        }
        return Optional.empty();
    }

}
