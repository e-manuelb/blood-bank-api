package br.com.ecb.bloodbankapi.domain.models.person;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;
import java.util.Random;

@SpringBootTest
public class PersonInfoTest {

    @Test
    public void testAllArgsConstructorSuccessfully() {
        Faker faker = new Faker(new Locale("pt-BR"));

        String[] genders = {"Masculino", "Feminino"};
        String[] bloodTypes = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};

        Random random = new Random();

        PersonInfo personInfo = new PersonInfo(
                (long) 1,
                faker.idNumber().valid(),
                faker.idNumber().valid(),
                genders[random.nextInt(genders.length)],
                faker.name().fullName(),
                faker.name().fullName(),
                1 + (2 - 1) * random.nextDouble(),
                40 + (120 - 40) * random.nextDouble(),
                bloodTypes[random.nextInt(bloodTypes.length)],
                new Person()
        );

        Assertions.assertNotNull(personInfo.getId());
        Assertions.assertNotNull(personInfo.getCpf());
        Assertions.assertNotNull(personInfo.getRg());
        Assertions.assertNotNull(personInfo.getGender());
        Assertions.assertNotNull(personInfo.getMotherName());
        Assertions.assertNotNull(personInfo.getFatherName());
        Assertions.assertNotNull(personInfo.getHeight());
        Assertions.assertNotNull(personInfo.getWeight());
        Assertions.assertNotNull(personInfo.getBloodType());
        Assertions.assertNotNull(personInfo.getPerson());
    }

    @Test
    public void testNoArgsConstructorSuccessfully() {
        PersonInfo personInfo = new PersonInfo();

        Assertions.assertNotNull(personInfo);
    }

    @Test
    public void testPersonInfoCreatedSuccessfully() {
        Faker faker = new Faker(new Locale("pt-BR"));

        String[] genders = {"Masculino", "Feminino"};
        String[] bloodTypes = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};

        Random random = new Random();

        PersonInfo personInfo = new PersonInfo()
                .setId((long) 1)
                .setCpf(faker.idNumber().valid())
                .setRg(faker.idNumber().valid())
                .setGender(genders[random.nextInt(genders.length)])
                .setMotherName(faker.name().fullName())
                .setFatherName(faker.name().fullName())
                .setHeight(1 + (2 - 1) * random.nextDouble())
                .setWeight(40 + (120 - 40) * random.nextDouble())
                .setBloodType(bloodTypes[random.nextInt(bloodTypes.length)])
                .setPerson(new Person());

        Assertions.assertNotNull(personInfo.getId());
        Assertions.assertNotNull(personInfo.getCpf());
        Assertions.assertNotNull(personInfo.getRg());
        Assertions.assertNotNull(personInfo.getGender());
        Assertions.assertNotNull(personInfo.getMotherName());
        Assertions.assertNotNull(personInfo.getFatherName());
        Assertions.assertNotNull(personInfo.getHeight());
        Assertions.assertNotNull(personInfo.getWeight());
        Assertions.assertNotNull(personInfo.getBloodType());
        Assertions.assertNotNull(personInfo.getPerson());
    }
}
