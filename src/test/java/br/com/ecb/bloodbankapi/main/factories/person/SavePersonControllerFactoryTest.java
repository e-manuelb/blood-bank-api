package br.com.ecb.bloodbankapi.main.factories.person;

import br.com.ecb.bloodbankapi.controllers.person.SavePersonController;
import br.com.ecb.bloodbankapi.domain.features.person.SavePerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SavePersonControllerFactoryTest {
    private SavePerson savePersonService;

    private SavePersonControllerFactory savePersonControllerFactory;

    @BeforeEach
    void init() {
        savePersonService = Mockito.mock(SavePerson.class);
        savePersonControllerFactory = new SavePersonControllerFactory(savePersonService);
    }

    @Test
    public void testMakeGetProcessedInformationControllerFactorySuccessfully() {
        SavePersonController savePersonController = savePersonControllerFactory.makeSavePersonController();

        Assertions.assertNotNull(savePersonController);
    }
}
