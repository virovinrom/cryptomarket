package com.investment.cryptomarket.businesslogic.database;

import com.investment.cryptomarket.businesslogic.builders.crypto.Crypto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CryptoRepository extends CrudRepository<Crypto, Integer> {
    Optional<Crypto> findByTitle(String title);
}
