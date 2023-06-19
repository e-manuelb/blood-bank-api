package br.com.ecb.bloodbankapi.data.services;

import br.com.ecb.bloodbankapi.data.factories.PersonAddressFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonInfoFactory;
import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.data.services.person.SavePersonService;
import br.com.ecb.bloodbankapi.domain.features.*;
import br.com.ecb.bloodbankapi.domain.features.person.ListPersons;
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
public class GetProcessedInformationServiceTest {
    private SavePerson savePersonService;
    private GetProcessedInformationService getProcessedInformationService;
    private PersonRepository personRepository;
    private SavePersonAddress savePersonAddressService;
    private SavePersonInfo savePersonInfoService;
    private ListPersons listPersonsService;
    private GetPersonQuantityForEachState getPersonQuantityForEachStateService;
    private GetAvailableDonorsForEachBloodType getAvailableDonorsForEachBloodTypeService;
    private GetAverageAgeForEachBloodType getAverageAgeForEachBloodTypeService;
    private GetAverageBMIPerAge getAverageBMIPerAgeService;
    private GetPercentageOfObeseMenAndWomen getPercentageOfObeseMenAndWomen;

    @BeforeEach
    public void init() {
        savePersonService = Mockito.mock(SavePerson.class);
        personRepository = Mockito.mock(PersonRepository.class);
        savePersonAddressService = Mockito.mock(SavePersonAddress.class);
        savePersonInfoService = Mockito.mock(SavePersonInfo.class);

        listPersonsService = Mockito.mock(ListPersons.class);
        getPersonQuantityForEachStateService = Mockito.mock(GetPersonQuantityForEachState.class);
        getAvailableDonorsForEachBloodTypeService = Mockito.mock(GetAvailableDonorsForEachBloodType.class);
        getAverageAgeForEachBloodTypeService = Mockito.mock(GetAverageAgeForEachBloodType.class);
        getAverageBMIPerAgeService = Mockito.mock(GetAverageBMIPerAge.class);
        getPercentageOfObeseMenAndWomen = Mockito.mock(GetPercentageOfObeseMenAndWomen.class);

        savePersonService = new SavePersonService(personRepository, savePersonAddressService, savePersonInfoService);

        getProcessedInformationService = new GetProcessedInformationService(
                listPersonsService,
                getPersonQuantityForEachStateService,
                getAvailableDonorsForEachBloodTypeService,
                getAverageAgeForEachBloodTypeService,
                getAverageBMIPerAgeService,
                getPercentageOfObeseMenAndWomen
        );
    }

    @Test
    public void testGetProcessedInformationSuccessfully() {
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

        Map<String, Object> processedInformation = getProcessedInformationService.handle();

        Assertions.assertNotNull(processedInformation);
    }
}
