package com.investment.cryptomarket.businesslogic.database;

import com.investment.cryptomarket.businesslogic.builders.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByLogin(String login);
}
