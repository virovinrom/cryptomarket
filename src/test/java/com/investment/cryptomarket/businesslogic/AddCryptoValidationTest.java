package com.investment.cryptomarket.businesslogic;

import com.investment.cryptomarket.businesslogic.addcrypto.AddCryptoRequest;
import com.investment.cryptomarket.businesslogic.addcrypto.AddCryptoValidator;
import com.investment.cryptomarket.businesslogic.database.CryptoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AddCryptoValidationTest {
    @Mock
    private CryptoRepository repository;
    @Mock
    private AddCryptoValidator validator;
    //@InjectMocks
    //private AddCryptoService service = new AddCryptoServiceImpl();


    @Test
    public void finedByTitleInValidationTest() {
        List<Errors> errors = new ArrayList<>();
        errors.add(new Errors("title", "Must not be repeated"));
        AddCryptoRequest request = new AddCryptoRequest("Bitcoins", 444.);
        Mockito.when(validator.validate(request))
                .thenReturn(errors);
        List<Errors> errorsReturn = validator.validate(request);
        assertEquals(errorsReturn.size(), 1);
        assertEquals(errors.get(0).getField(), "title");
        assertEquals(errors.get(0).getErrorMessage(), "Must not be repeated");


    }

}
