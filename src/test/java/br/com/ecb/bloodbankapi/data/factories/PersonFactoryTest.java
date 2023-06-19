package br.com.ecb.bloodbankapi.data.factories;

import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonFactoryTest {

    @Test
    public void testPersonCreatedSuccessfully() {
        Person person = new PersonFactory().create();

        Assertions.assertNotNull(person.getName());
        Assertions.assertNotNull(person.getEmail());
        Assertions.assertNotNull(person.getDateOfBirth());
        Assertions.assertNotNull(person.getPhone());
        Assertions.assertNotNull(person.getLandline());
    }
}
