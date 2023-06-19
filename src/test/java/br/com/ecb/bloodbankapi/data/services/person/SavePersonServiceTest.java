package br.com.ecb.bloodbankapi.data.services.person;

import br.com.ecb.bloodbankapi.data.factories.PersonAddressFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonInfoFactory;
import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
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
public class SavePersonServiceTest {
    private SavePersonService savePersonService;
    private PersonRepository personRepository;
    private SavePersonAddress savePersonAddressService;
    private SavePersonInfo savePersonInfoService;

    @BeforeEach
    public void init() {
        personRepository = Mockito.mock(PersonRepository.class);
        savePersonAddressService = Mockito.mock(SavePersonAddress.class);
        savePersonInfoService = Mockito.mock(SavePersonInfo.class);

        savePersonService = new SavePersonService(personRepository, savePersonAddressService, savePersonInfoService);
    }

    @Test
    public void testCreatePersonSuccessfully() {
        Person person = new PersonFactory().create();
        PersonAddress address = new PersonAddressFactory().create(person);
        PersonInfo info = new PersonInfoFactory().create(person);

        person.setAddress(address);
        person.setInfo(info);

        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(person);
        Mockito.when(savePersonAddressService.handle(Mockito.any(PersonAddress.class))).thenReturn(address);
        Mockito.when(savePersonInfoService.handle(Mockito.any(PersonInfo.class))).thenReturn(info);

        Person createdPerson = savePersonService.handle(person);

        // Assert Person attributes
        Assertions.assertEquals(person.getName(), createdPerson.getName());
        Assertions.assertEquals(person.getEmail(), createdPerson.getEmail());
        Assertions.assertEquals(person.getDateOfBirth(), createdPerson.getDateOfBirth());
        Assertions.assertEquals(person.getPhone(), createdPerson.getPhone());
        Assertions.assertEquals(person.getLandline(), createdPerson.getLandline());

        // Assert Address attributes
        Assertions.assertEquals(person.getAddress().getZipCode(), createdPerson.getAddress().getZipCode());
        Assertions.assertEquals(person.getAddress().getAddress(), createdPerson.getAddress().getAddress());
        Assertions.assertEquals(person.getAddress().getNumber(), createdPerson.getAddress().getNumber());
        Assertions.assertEquals(person.getAddress().getNeighborhood(), createdPerson.getAddress().getNeighborhood());
        Assertions.assertEquals(person.getAddress().getState(), createdPerson.getAddress().getState());

        // Assert Info attributes

        Assertions.assertEquals(person.getInfo().getCpf(), createdPerson.getInfo().getCpf());
        Assertions.assertEquals(person.getInfo().getRg(), createdPerson.getInfo().getRg());
        Assertions.assertEquals(person.getInfo().getGender(), createdPerson.getInfo().getGender());
        Assertions.assertEquals(person.getInfo().getMotherName(), createdPerson.getInfo().getMotherName());
        Assertions.assertEquals(person.getInfo().getFatherName(), createdPerson.getInfo().getFatherName());
        Assertions.assertEquals(person.getInfo().getHeight(), createdPerson.getInfo().getHeight());
        Assertions.assertEquals(person.getInfo().getWeight(), createdPerson.getInfo().getWeight());
        Assertions.assertEquals(person.getInfo().getBloodType(), createdPerson.getInfo().getBloodType());
    }
}
