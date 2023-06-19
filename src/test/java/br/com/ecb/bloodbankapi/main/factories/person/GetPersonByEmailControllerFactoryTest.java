package br.com.ecb.bloodbankapi.main.factories.person;

import br.com.ecb.bloodbankapi.controllers.person.GetPersonByEmailController;
import br.com.ecb.bloodbankapi.domain.features.person.GetPersonByEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetPersonByEmailControllerFactoryTest {
    private GetPersonByEmail getPersonByEmailService;

    private GetPersonByEmailControllerFactory getPersonByEmailControllerFactory;

    @BeforeEach
    void init() {
        getPersonByEmailService = Mockito.mock(GetPersonByEmail.class);
        getPersonByEmailControllerFactory = new GetPersonByEmailControllerFactory(getPersonByEmailService);
    }

    @Test
    public void testMakeGetProcessedInformationControllerFactorySuccessfully() {
        GetPersonByEmailController getPersonByEmailController = getPersonByEmailControllerFactory.makeGetPersonByEmailController();

        Assertions.assertNotNull(getPersonByEmailController);
    }
}
