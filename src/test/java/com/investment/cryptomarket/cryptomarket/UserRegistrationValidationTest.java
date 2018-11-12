package com.investment.cryptomarket.cryptomarket;

import com.investment.cryptomarket.businesslogic.Errors;
import com.investment.cryptomarket.businesslogic.database.UserRepository;
import com.investment.cryptomarket.businesslogic.userregistration.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegistrationValidationTest {

    @Autowired
    private UserRegistrationService service;

    @Test
    public void shouldReturnErrorWhenLoginIsNull() {
        UserRegistrationRequest request = new UserRegistrationRequest(null, "password");
        UserRegistrationResponse response = service.register(request);
        List<Errors> errors = response.getErrors();
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "login");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be empty");
    }
}
