package br.com.ecb.bloodbankapi.data.services.person;

import br.com.ecb.bloodbankapi.data.factories.PersonAddressFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonInfoFactory;
import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.domain.features.person.SavePerson;
import br.com.ecb.bloodbankapi.domain.features.person.address.SavePersonAddress;
import br.com.ecb.bloodbankapi.domain.features.person.info.SavePersonInfo;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.domain.models.person.PersonAddress;
import br.com.ecb.bloodbankapi.domain.models.person.PersonInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetPersonByEmailServiceTest {
    private SavePerson savePersonService;
    private GetPersonByEmailService getPersonByEmailService;
    private PersonRepository personRepository;
    private SavePersonAddress savePersonAddressService;
    private SavePersonInfo savePersonInfoService;

    @BeforeEach
    public void init() {
        savePersonService = Mockito.mock(SavePerson.class);
        personRepository = Mockito.mock(PersonRepository.class);
        savePersonAddressService = Mockito.mock(SavePersonAddress.class);
        savePersonInfoService = Mockito.mock(SavePersonInfo.class);

        savePersonService = new SavePersonService(personRepository, savePersonAddressService, savePersonInfoService);
        getPersonByEmailService = new GetPersonByEmailService(personRepository);
    }

    @Test
    public void testGetPersonByEmailSuccessfully() {
        Person person = new PersonFactory().create();
        PersonAddress address = new PersonAddressFactory().create(person);
        PersonInfo info = new PersonInfoFactory().create(person);

        person.setAddress(address);
        person.setInfo(info);

        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(person);
        Mockito.when(savePersonAddressService.handle(Mockito.any(PersonAddress.class))).thenReturn(address);
        Mockito.when(savePersonInfoService.handle(Mockito.any(PersonInfo.class))).thenReturn(info);

        Person createdPerson = savePersonService.handle(person);

        Mockito.when(personRepository.findPersonByEmail(createdPerson.getEmail())).thenReturn(createdPerson);

        Person personWithCertainEmail = getPersonByEmailService.handle(createdPerson.getEmail());

        // Assert Person attributes
        Assertions.assertEquals(createdPerson.getName(), personWithCertainEmail.getName());
        Assertions.assertEquals(createdPerson.getEmail(), personWithCertainEmail.getEmail());
        Assertions.assertEquals(createdPerson.getDateOfBirth(), personWithCertainEmail.getDateOfBirth());
        Assertions.assertEquals(createdPerson.getPhone(), personWithCertainEmail.getPhone());
        Assertions.assertEquals(createdPerson.getLandline(), personWithCertainEmail.getLandline());

        // Assert Address attributes
        Assertions.assertEquals(createdPerson.getAddress().getZipCode(), personWithCertainEmail.getAddress().getZipCode());
        Assertions.assertEquals(createdPerson.getAddress().getAddress(), personWithCertainEmail.getAddress().getAddress());
        Assertions.assertEquals(createdPerson.getAddress().getNumber(), personWithCertainEmail.getAddress().getNumber());
        Assertions.assertEquals(createdPerson.getAddress().getNeighborhood(), personWithCertainEmail.getAddress().getNeighborhood());
        Assertions.assertEquals(createdPerson.getAddress().getState(), personWithCertainEmail.getAddress().getState());

        // Assert Info attributes

        Assertions.assertEquals(createdPerson.getInfo().getCpf(), personWithCertainEmail.getInfo().getCpf());
        Assertions.assertEquals(createdPerson.getInfo().getRg(), personWithCertainEmail.getInfo().getRg());
        Assertions.assertEquals(createdPerson.getInfo().getGender(), personWithCertainEmail.getInfo().getGender());
        Assertions.assertEquals(createdPerson.getInfo().getMotherName(), personWithCertainEmail.getInfo().getMotherName());
        Assertions.assertEquals(createdPerson.getInfo().getFatherName(), personWithCertainEmail.getInfo().getFatherName());
        Assertions.assertEquals(createdPerson.getInfo().getHeight(), personWithCertainEmail.getInfo().getHeight());
        Assertions.assertEquals(createdPerson.getInfo().getWeight(), personWithCertainEmail.getInfo().getWeight());
        Assertions.assertEquals(createdPerson.getInfo().getBloodType(), personWithCertainEmail.getInfo().getBloodType());
    }
}
