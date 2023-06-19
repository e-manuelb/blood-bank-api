package br.com.ecb.bloodbankapi.data.services.person.address;

import br.com.ecb.bloodbankapi.data.factories.PersonAddressFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonFactory;
import br.com.ecb.bloodbankapi.data.repositories.person.PersonAddressRepository;
import br.com.ecb.bloodbankapi.domain.features.person.address.SavePersonAddress;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.domain.models.person.PersonAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SavePersonAddressServiceTest {
    private PersonAddressRepository personAddressRepository;

    private SavePersonAddress savePersonAddressService;

    @BeforeEach
    public void init() {
        personAddressRepository = Mockito.mock(PersonAddressRepository.class);

        savePersonAddressService = new SavePersonAddressService(personAddressRepository);
    }

    @Test
    public void testSavePersonAddressSuccessfully() {
        Person person = new PersonFactory().create();
        PersonAddress address = new PersonAddressFactory().create(person);

        Mockito.when(personAddressRepository.save(Mockito.any(PersonAddress.class))).thenReturn(address);

        PersonAddress createdAddress = savePersonAddressService.handle(address);

        Assertions.assertEquals(address.getZipCode(), createdAddress.getZipCode());
        Assertions.assertEquals(address.getAddress(), createdAddress.getAddress());
        Assertions.assertEquals(address.getNumber(), createdAddress.getNumber());
        Assertions.assertEquals(address.getNeighborhood(), createdAddress.getNeighborhood());
        Assertions.assertEquals(address.getState(), createdAddress.getState());
        Assertions.assertEquals(address.getPerson(), createdAddress.getPerson());
    }
}
