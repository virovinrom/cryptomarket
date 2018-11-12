package com.investment.cryptomarket.businesslogic.builders;

public class CryptoBuilder {
    private Long id;
    private String title;
    private Double currency;

    private CryptoBuilder() {}

    public static CryptoBuilder cryptoBuilder() {
        return new CryptoBuilder();
    }

    public Crypto build() {
        Crypto crypto = new Crypto();
        crypto.setId(id);
        crypto.setTitle(title);
        crypto.setCurrency(currency);
        return crypto;
    }

    public CryptoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CryptoBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CryptoBuilder withCurrensy(Double currency) {
        this.currency = currency;
        return this;
    }

}
