package com.investment.cryptomarket.businesslogic.controller;

import com.investment.cryptomarket.businesslogic.builders.user.User;
import com.investment.cryptomarket.businesslogic.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserEnterController {

    @RequestMapping("/")
    public User greeting(User user) {
        return user;
    }


}
