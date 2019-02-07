package com.investment.cryptomarket.businesslogic.controller;

import com.investment.cryptomarket.businesslogic.builders.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEnterController {
    private Logger logger = LoggerFactory.getLogger(UserEnterController.class);


    @GetMapping("/")
    public User showUser() {
        User user = new User();
        user.setLogin("testLogin");
        return user;
    }

    @PostMapping("/")
    public void postLogin(@RequestBody User user) {

        logger.info(user.getLogin());
    }


}
