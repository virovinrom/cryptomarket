package com.investment.cryptomarket.cryptomarket;


import com.investment.cryptomarket.businesslogic.builders.User;
import com.investment.cryptomarket.businesslogic.database.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryInputCheckTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void inputToRepoTest(){

        User user = new User();
        user.setLogin("slava");
        user.setPassword("pass");

        userRepository.save(user);

        assertThat(userRepository.findByLogin(user.getLogin())).get().isEqualTo(user);

    }


}
