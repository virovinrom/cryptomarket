package com.investment.cryptomarket.businesslogic.user.userregistration;

import com.investment.cryptomarket.businesslogic.Errors;
import com.investment.cryptomarket.businesslogic.builders.user.User;
import com.investment.cryptomarket.businesslogic.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.investment.cryptomarket.businesslogic.builders.user.UserBuilder.createUser;

@Component
public class UserRegistrationServiceImpl implements UserRegistrationService {
    @Autowired
    private UserRegistrationValidator validator;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) {


        List<Errors> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            return new UserRegistrationResponse(validationErrors);
        }


        User user = createUser()
                .withLogin(request.getLogin())
                .withPassword(request.getPassword())
                .build();


        userRepository.save(user);

        return new UserRegistrationResponse(user.getId());
    }

}
