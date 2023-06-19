package br.com.ecb.bloodbankapi.data.factories;

import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.domain.models.person.PersonInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonInfoFactoryTest {

    @Test
    public void testPersonInfoCreatedSuccessfully() {
        Person person = new PersonFactory().create();
        PersonInfo info = new PersonInfoFactory().create(person);

        Assertions.assertNotNull(info.getCpf());
        Assertions.assertNotNull(info.getRg());
        Assertions.assertNotNull(info.getGender());
        Assertions.assertNotNull(info.getMotherName());
        Assertions.assertNotNull(info.getFatherName());
        Assertions.assertNotNull(info.getHeight());
        Assertions.assertNotNull(info.getWeight());
        Assertions.assertNotNull(info.getBloodType());
        Assertions.assertNotNull(info.getPerson());
    }
}
