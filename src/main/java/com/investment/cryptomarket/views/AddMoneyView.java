package com.investment.cryptomarket.views;

import com.investment.cryptomarket.businesslogic.addmoney.AddMoneyRequest;
import com.investment.cryptomarket.businesslogic.addmoney.AddMoneyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class AddMoneyView implements View {
    @Autowired
    private AddMoneyService addMoneyService;
    @Override
    public void execute() {
        System.out.println();
        System.out.println("Please enter money value; ");
        Scanner scanner = new Scanner(System.in);
        Double money = Double.parseDouble(scanner.nextLine());
        //AddMoneyRequest request = new AddMoneyRequest();
    }
}
