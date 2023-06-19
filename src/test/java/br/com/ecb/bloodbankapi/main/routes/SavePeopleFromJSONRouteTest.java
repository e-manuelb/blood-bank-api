package br.com.ecb.bloodbankapi.main.routes;

import br.com.ecb.bloodbankapi.controllers.person.GetPersonByEmailController;
import br.com.ecb.bloodbankapi.controllers.person.SavePersonController;
import br.com.ecb.bloodbankapi.domain.features.person.GetPersonByEmail;
import br.com.ecb.bloodbankapi.domain.features.person.SavePerson;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.shared.dtos.request.SavePeopleFromJSONDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SavePeopleFromJSONRouteTest {
    private SavePerson savePersonService;
    private SavePersonController savePersonController;
    private GetPersonByEmail getPersonByEmailService;
    private GetPersonByEmailController getPersonByEmailController;
    private SavePeopleFromJSONRoute savePeopleFromJSONRoute;

    @BeforeEach
    public void init() {
        savePersonService = Mockito.mock(SavePerson.class);
        savePersonController = Mockito.mock(SavePersonController.class);
        getPersonByEmailService = Mockito.mock(GetPersonByEmail.class);
        getPersonByEmailController = Mockito.mock(GetPersonByEmailController.class);

        savePeopleFromJSONRoute = new SavePeopleFromJSONRoute(savePersonService, getPersonByEmailService);
    }

    @Test
    public void testSavePeopleFromJSONSuccessfully() {
        List<SavePeopleFromJSONDTO> savePeopleFromJSONDTOs = new ArrayList<>();
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(new ArrayList<>(), HttpStatus.CREATED);

        List<Person> people = new ArrayList<>();

        savePeopleFromJSONDTOs.forEach(savePeopleFromJSONDTO -> {
            Person person = new Person();

            Mockito.when(getPersonByEmailService.handle(savePeopleFromJSONDTO.getEmail())).thenReturn(person);

            if (getPersonByEmailController.handle(savePeopleFromJSONDTO.getEmail()) != null) {

            } else {
                Mockito.when(savePersonService.handle(Mockito.any(Person.class))).thenReturn(person);

                people.add(savePersonController.handle(person));
            }
        });

        ResponseEntity<?> response = savePeopleFromJSONRoute.handle(savePeopleFromJSONDTOs);

        Assertions.assertEquals(expectedResponse, response);
    }
}
