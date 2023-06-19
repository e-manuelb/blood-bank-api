package br.com.ecb.bloodbankapi.domain.models.person;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SpringBootTest
public class PersonTest {

    @Test
    public void testAllArgsConstructorSuccessfully() {
        Faker faker = new Faker(new Locale("pt-BR"));

        Person person = new Person(
                (long) 1,
                faker.name().fullName(),
                faker.internet().emailAddress(),
                LocalDate.parse(new SimpleDateFormat("dd/MM/yyyy").format(faker.date().birthday()), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                faker.phoneNumber().cellPhone(),
                faker.phoneNumber().phoneNumber(),
                new PersonAddress(),
                new PersonInfo(),
                Timestamp.from(Instant.now()),
                Timestamp.from(Instant.now())
        );

        Assertions.assertNotNull(person);
    }

    @Test
    public void testNoArgsConstructorSuccessfully() {
        Person person = new Person();

        Assertions.assertNotNull(person);
    }

    @Test
    public void testPersonCreatedSuccessfully() {
        Faker faker = new Faker(new Locale("pt-BR"));

        Person person = new Person()
                .setId((long) 1)
                .setName(faker.name().fullName())
                .setEmail(faker.internet().emailAddress())
                .setDateOfBirth(LocalDate.parse(new SimpleDateFormat("dd/MM/yyyy").format(faker.date().birthday()), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .setPhone(faker.phoneNumber().cellPhone())
                .setLandline(faker.phoneNumber().phoneNumber())
                .setCreatedAt(Timestamp.from(Instant.now()))
                .setUpdatedAt(Timestamp.from(Instant.now()));

        Assertions.assertNotNull(person.getId());
        Assertions.assertNotNull(person.getName());
        Assertions.assertNotNull(person.getEmail());
        Assertions.assertNotNull(person.getDateOfBirth());
        Assertions.assertNotNull(person.getPhone());
        Assertions.assertNotNull(person.getLandline());
        Assertions.assertNotNull(person.getCreatedAt());
        Assertions.assertNotNull(person.getUpdatedAt());
    }

    @Test
    public void testGetAgeSuccessfully() {
        Faker faker = new Faker(new Locale("pt-BR"));

        Person person = new Person()
                .setId((long) 1)
                .setName(faker.name().fullName())
                .setEmail(faker.internet().emailAddress())
                .setDateOfBirth(LocalDate.parse(new SimpleDateFormat("dd/MM/yyyy").format(faker.date().birthday()), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .setPhone(faker.phoneNumber().cellPhone())
                .setLandline(faker.phoneNumber().phoneNumber())
                .setCreatedAt(Timestamp.from(Instant.now()))
                .setUpdatedAt(Timestamp.from(Instant.now()));

        Assertions.assertNotNull(person.getAge());
    }
}
