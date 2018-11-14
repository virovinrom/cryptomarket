package com.investment.cryptomarket.views;

import com.investment.cryptomarket.businesslogic.user.userenter.UserEnterRequest;
import com.investment.cryptomarket.businesslogic.user.userenter.UserEnterResponse;
import com.investment.cryptomarket.businesslogic.user.userenter.UserEnterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class UserEnterView implements View {
    @Autowired
    private UserEnterService service;
    @Override
    public void execute() {
        System.out.println();
        System.out.println("Registration user enter");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter login:");
        String login = sc.nextLine();
        System.out.print("Enter password:");
        String password = sc.nextLine();
        UserEnterRequest request = new UserEnterRequest(login, password);
        UserEnterResponse response = service.enter(request);
    }
}
