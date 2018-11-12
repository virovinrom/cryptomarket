package com.investment;

import com.investment.cryptomarket.views.View;
import com.investment.cryptomarket.views.userregistration.UserRegistrationView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@SpringBootApplication(scanBasePackages = { "com.investment.cryptomarket.businesslogic",  "com.investment.cryptomarket.views"})
public class CryptoMarketApplication {

    public static void main(String[] args) {


        SpringApplication.run(CryptoMarketApplication.class, args);
        Map<Integer, View> userMainMenu = new HashMap<>();
        UserRegistrationView userRegistrationView = new UserRegistrationView();
        userRegistrationView.execute();
//        while (true) {
//            printProgramMenu();
//            int menuItem = getFromUserMenuItemToExecute();
//            View view = userMainMenu.get(menuItem);
//            view.execute();
//        }
    }

    private static void printProgramMenu() {

        System.out.println("Program Menu:");
        System.out.println("1. Login");
        System.out.println("2. Registration new user");

    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }


}
