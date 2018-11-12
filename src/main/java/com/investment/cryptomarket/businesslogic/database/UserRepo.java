package com.investment.cryptomarket.businesslogic.database;

import com.investment.cryptomarket.businesslogic.builders.User;

import java.util.Optional;

public interface UserRepo {
    Optional<User> findByLogin(String login);
}
