package br.com.ecb.bloodbankapi.data.factories;

import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.domain.models.person.PersonInfo;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class PersonInfoFactory {

    public PersonInfo create(Person person) {
        Faker faker = new Faker(new Locale("pt-BR"));

        String[] genders = {"Masculino", "Feminino"};
        String[] bloodTypes = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};

        Random random = new Random();

        return new PersonInfo()
                .setCpf(faker.idNumber().valid())
                .setRg(faker.idNumber().valid())
                .setGender(genders[random.nextInt(genders.length)])
                .setMotherName(faker.name().fullName())
                .setFatherName(faker.name().fullName())
                .setHeight(1 + (2 - 1) * random.nextDouble())
                .setWeight(40 + (120 - 40) * random.nextDouble())
                .setBloodType(bloodTypes[random.nextInt(bloodTypes.length)])
                .setPerson(person);
    }
}
