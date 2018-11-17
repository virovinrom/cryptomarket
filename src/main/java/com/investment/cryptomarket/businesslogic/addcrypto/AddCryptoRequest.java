package com.investment.cryptomarket.businesslogic.addcrypto;

public class AddCryptoRequest {
    private String title;
    private Double currency;

    public AddCryptoRequest(String title, Double currency) {
        this.title = title;
        this.currency = currency;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCurrency() {
        return currency;
    }

    public void setCurrency(Double currency) {
        this.currency = currency;
    }
}
