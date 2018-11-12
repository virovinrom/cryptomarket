package com.investment.cryptomarket.views.userregistration;

import com.investment.cryptomarket.businesslogic.database.UserRepository;
import com.investment.cryptomarket.businesslogic.userregistration.UserRegistrationRequest;
import com.investment.cryptomarket.businesslogic.userregistration.UserRegistrationResponse;
import com.investment.cryptomarket.businesslogic.userregistration.UserRegistrationService;
import com.investment.cryptomarket.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserRegistrationView implements View {
    @Autowired
    private UserRegistrationService service;
@Autowired
private UserRepository userRepository;
    @Override
    public void execute() {

        System.out.println();
        System.out.println("Registration of new user");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter login:");
        String login = sc.nextLine();
        System.out.print("Enter password:");
        String password = sc.nextLine();

        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest(login, password);
        UserRegistrationResponse response = service.register(userRegistrationRequest);

        if (response.isSuccess()) {
            System.out.println("Product successfully added to list!");
            System.out.println();
        } else {
            response.getErrors().forEach(error -> {
                System.out.println("Error field = " + error.getField());
                System.out.println("Error message = " + error.getErrorMessage());
            });
            System.out.println();
        }

    }
}
