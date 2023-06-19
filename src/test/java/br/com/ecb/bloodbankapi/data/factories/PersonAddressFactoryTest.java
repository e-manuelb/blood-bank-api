package br.com.ecb.bloodbankapi.data.factories;

import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.domain.models.person.PersonAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonAddressFactoryTest {

    @Test
    public void testPersonAddressCreatedSuccessfully() {
        Person person = new PersonFactory().create();
        PersonAddress address = new PersonAddressFactory().create(person);

        Assertions.assertNotNull(address.getZipCode());
        Assertions.assertNotNull(address.getAddress());
        Assertions.assertNotNull(address.getNumber());
        Assertions.assertNotNull(address.getNeighborhood());
        Assertions.assertNotNull(address.getState());
        Assertions.assertNotNull(address.getPerson());
    }
}
