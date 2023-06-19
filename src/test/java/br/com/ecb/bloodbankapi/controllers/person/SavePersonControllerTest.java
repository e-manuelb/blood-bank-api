package br.com.ecb.bloodbankapi.controllers.person;

import br.com.ecb.bloodbankapi.domain.features.person.SavePerson;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SavePersonControllerTest {
    private SavePerson savePersonService;
    private SavePersonController savePersonController;

    @BeforeEach
    public void init() {
        savePersonService = Mockito.mock(SavePerson.class);

        savePersonController = new SavePersonController(savePersonService);
    }

    @Test
    public void testSaveControllerSuccessfully() {
        Person person = new Person();

        Mockito.when(savePersonService.handle(Mockito.any(Person.class))).thenReturn(person);

        Person personCreated = savePersonController.handle(person);

        Assertions.assertNotNull(personCreated);
        Assertions.assertEquals(person, personCreated);
    }
}
