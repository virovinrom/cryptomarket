package com.investment.cryptomarket.businesslogic.user.userenter;

import com.investment.cryptomarket.businesslogic.Errors;

import java.util.List;

public class UserEnterResponse {

    private Long userId;

    private boolean success;

    private List<Errors> errors;

    public UserEnterResponse(Long userId) {
        this.userId = userId;
        this.success = true;
        this.errors = null;
    }

    public UserEnterResponse(List<Errors> errors) {
        this.userId = null;
        this.success = false;
        this.errors = errors;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
