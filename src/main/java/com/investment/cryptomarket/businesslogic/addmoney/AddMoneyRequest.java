package com.investment.cryptomarket.businesslogic.addmoney;

import com.investment.cryptomarket.businesslogic.builders.user.User;

public class AddMoneyRequest {
    private String login;
    private Double money;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public AddMoneyRequest(User user, Double money) {
        this.user = user;
        this.money = money;

    }
}
