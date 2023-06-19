package br.com.ecb.bloodbankapi.controllers.person;

import br.com.ecb.bloodbankapi.domain.features.person.GetPersonByEmail;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GetPersonByEmailControllerTest {
    private GetPersonByEmail getPersonByEmailService;

    private GetPersonByEmailController getPersonByEmailController;

    @BeforeEach
    public void init() {
        getPersonByEmailService = Mockito.mock(GetPersonByEmail.class);

        getPersonByEmailController = new GetPersonByEmailController(getPersonByEmailService);
    }

    @Test
    public void testGetPersonByEmailControllerSuccessfully() {
        String email = "test@test.com";
        Person person = new Person().setEmail(email);

        Mockito.when(getPersonByEmailService.handle(email)).thenReturn(person);

        Person personCreated = getPersonByEmailController.handle(email);

        Assertions.assertNotNull(personCreated);
        Assertions.assertEquals(person, personCreated);
    }
}
