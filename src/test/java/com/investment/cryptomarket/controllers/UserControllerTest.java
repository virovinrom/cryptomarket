package com.investment.cryptomarket.controllers;

import com.investment.cryptomarket.businesslogic.builders.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    private MockMvc mockMvc;
    @Test
    private void shouldReturnLoginPasswordTest() {
        User user = new User();
        user.setLogin("TestLogin");
        user.setPassword("TestPassword");


    }
}
