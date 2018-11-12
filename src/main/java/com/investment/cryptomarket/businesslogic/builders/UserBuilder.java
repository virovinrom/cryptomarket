package com.investment.cryptomarket.businesslogic.builders;

public class UserBuilder {
    private Long id;
    private String login;
    private String password;
    private Double count;

    private UserBuilder() {}

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }

    public UserBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

}
