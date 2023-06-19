package br.com.ecb.bloodbankapi.data.services;

import br.com.ecb.bloodbankapi.data.factories.PersonAddressFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonInfoFactory;
import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.data.services.person.ListPersonsService;
import br.com.ecb.bloodbankapi.data.services.person.SavePersonService;
import br.com.ecb.bloodbankapi.domain.features.GetBMI;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class GetAverageBMIPerAgeServiceTest {
    private SavePerson savePersonService;
    private ListPersonsService listPersonsService;
    private GetBMI getBMIService;
    private GetAverageBMIPerAgeService getAverageBMIPerAgeService;
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
        listPersonsService = new ListPersonsService(personRepository);
        getBMIService = new GetBMIService();
        getAverageBMIPerAgeService = new GetAverageBMIPerAgeService(getBMIService);
    }

    @Test
    public void testGetAverageBMIPerAgeSuccessfully() {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Person person = new PersonFactory().create();
            PersonAddress address = new PersonAddressFactory().create(person);
            PersonInfo info = new PersonInfoFactory().create(person);

            person.setAddress(address);
            person.setInfo(info);

            Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(person);
            Mockito.when(savePersonAddressService.handle(Mockito.any(PersonAddress.class))).thenReturn(address);
            Mockito.when(savePersonInfoService.handle(Mockito.any(PersonInfo.class))).thenReturn(info);

            Person createdPerson = savePersonService.handle(person);

            people.add(createdPerson);
        }

        Mockito.when(personRepository.findAll()).thenReturn(people);

        List<Person> listedPeople = listPersonsService.handle();

        Map<String, Double> averageBMIPerAge = getAverageBMIPerAgeService.handle(listedPeople);

        Assertions.assertNotNull(averageBMIPerAge);
    }
}
