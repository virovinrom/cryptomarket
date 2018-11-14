package com.investment.cryptomarket.businesslogic;

import com.investment.cryptomarket.SpringComponentConfig;
import com.investment.cryptomarket.businesslogic.builders.user.User;
import com.investment.cryptomarket.businesslogic.database.UserRepository;
import com.investment.cryptomarket.businesslogic.user.userenter.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(SpringComponentConfig.class)
public class UserEnterValidationTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEnterService service;


    @Before
    public void setUp() {
        User user = new User();
        user.setLogin("slavaTest");
        user.setPassword("password");
        userRepository.save(user);
    }

    @Test
    public void finedByLoginInRepositoryTest() {
        User lookingUser = userRepository.findByLogin("slavaTest").get();
        assertThat(lookingUser.getLogin()).isEqualTo("slavaTest");
    }

    @Test
    public void UserPasswordValidationTest() {
        UserEnterRequest request = new UserEnterRequest("slavaTest", "wrongpassword");
        UserEnterResponse response = service.enter(request);
        List<Errors> errors = response.getErrors();
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "password");
        assertEquals(errors.get(0).getErrorMessage(), "Incorrect password");
    }
}
