package com.investment.cryptomarket.businesslogic.userregistration;

import org.springframework.stereotype.Component;


public class UserRegistrationRequest {
    private String login;
    private String password;

    public UserRegistrationRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
