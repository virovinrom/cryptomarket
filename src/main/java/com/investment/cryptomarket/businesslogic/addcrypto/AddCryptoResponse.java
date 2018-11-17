package com.investment.cryptomarket.businesslogic.addcrypto;

import com.investment.cryptomarket.businesslogic.Errors;

import java.util.List;

public class AddCryptoResponse {

    private Long cryptoId;

    private boolean success;

    private List<Errors> errors;

    public AddCryptoResponse(Long cryptoId) {
        this.cryptoId = cryptoId;
        this.success = true;
        this.errors = null;
    }

    public AddCryptoResponse(List<Errors> errors) {
        this.cryptoId = null;
        this.success = false;
        this.errors = errors;
    }

    public Long getUserId() {
        return cryptoId;
    }

    public void setUserId(Long userId) {
        this.cryptoId= userId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }

}
