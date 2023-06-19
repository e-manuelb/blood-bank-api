package br.com.ecb.bloodbankapi.domain.models.person;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Locale;

@SpringBootTest
public class PersonAddressTest {

    @Test
    public void testAllArgsConstructorSuccessfully() {
        Faker faker = new Faker(new Locale("pt-BR"));

        PersonAddress address = new PersonAddress(
                (long) 1,
                faker.address().zipCode(),
                faker.address().streetName(),
                Integer.valueOf(faker.address().streetAddressNumber()),
                faker.name().fullName(),
                faker.address().state(),
                new Person(),
                Timestamp.from(Instant.now()),
                Timestamp.from(Instant.now())
        );

        Assertions.assertNotNull(address);
    }

    @Test
    public void testNoArgsConstructorSuccessfully() {
        PersonAddress address = new PersonAddress();

        Assertions.assertNotNull(address);
    }

    @Test
    public void testPersonAddressCreatedSuccessfully() {
        Faker faker = new Faker(new Locale("pt-BR"));

        PersonAddress address = new PersonAddress()
                .setId((long) 1)
                .setZipCode(faker.address().zipCode())
                .setAddress(faker.address().streetName())
                .setNumber(Integer.valueOf(faker.address().streetAddressNumber()))
                .setNeighborhood(faker.name().fullName())
                .setState(faker.address().state())
                .setPerson(new Person())
                .setCreatedAt(Timestamp.from(Instant.now()))
                .setUpdatedAt(Timestamp.from(Instant.now()));

        Assertions.assertNotNull(address.getId());
        Assertions.assertNotNull(address.getZipCode());
        Assertions.assertNotNull(address.getAddress());
        Assertions.assertNotNull(address.getNumber());
        Assertions.assertNotNull(address.getNeighborhood());
        Assertions.assertNotNull(address.getState());
        Assertions.assertNotNull(address.getPerson());
        Assertions.assertNotNull(address.getCreatedAt());
        Assertions.assertNotNull(address.getUpdatedAt());
    }
}
