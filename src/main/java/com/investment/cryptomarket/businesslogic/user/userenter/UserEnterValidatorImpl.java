package com.investment.cryptomarket.businesslogic.user.userenter;

import com.investment.cryptomarket.businesslogic.Errors;
import com.investment.cryptomarket.businesslogic.builders.user.User;
import com.investment.cryptomarket.businesslogic.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class UserEnterValidatorImpl implements UserEnterValidator {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Errors> validate(UserEnterRequest request) {
       // System.out.println(userRepository.findByLogin("slavaTest").get());
        List<Errors> errors = new ArrayList<>();
        validateLogin(request.getLogin()).ifPresent(errors::add);
        validatePassword(request.getPassword()).ifPresent(errors::add);
        validateLoginWithPassword(request.getLogin(), request.getPassword()).ifPresent(errors::add);

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

    private Optional<Errors> validateLoginWithPassword(String login, String password) {
        if (login != null && !login.isEmpty()) {
            Optional<User> userOpt = userRepository.findByLogin(login);
            if (!userOpt.isPresent()) {
                return Optional.of(new Errors("login", "Such login not found"));
            }
            if (!userOpt.get().getPassword().equals(password)){
                return  Optional.of(new Errors("password", "Incorrect password"));
            }
        }
        return Optional.empty();
    }
}
