package com.investment.cryptomarket.businesslogic.database;

import com.investment.cryptomarket.businesslogic.builders.crypto.Crypto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CryptoRepository extends CrudRepository<Crypto, Integer> {
    List<Crypto> findByTitle(String login);
}
