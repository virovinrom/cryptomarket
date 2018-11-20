package com.investment.cryptomarket.businesslogic.controller;

import com.investment.cryptomarket.businesslogic.builders.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @GetMapping("/")
    public ModelAndView userForm() {
        Map<String, User> user = new HashMap<>();
        user.put("user", new User());
        return new ModelAndView("userlogin", user);
    }


    @PostMapping("/")
    public String userEnter(@RequestBody User user) { //@ModelAttribute
        user.getLogin();
        return "result";
    }

}
