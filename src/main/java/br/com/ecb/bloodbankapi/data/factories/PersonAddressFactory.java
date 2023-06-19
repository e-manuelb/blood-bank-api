package br.com.ecb.bloodbankapi.data.factories;

import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.domain.models.person.PersonAddress;
import com.github.javafaker.Faker;

import java.util.Locale;

public class PersonAddressFactory {

    public PersonAddress create(Person person) {
        Faker faker = new Faker(new Locale("pt-BR"));

        return new PersonAddress()
                .setZipCode(faker.address().zipCode())
                .setAddress(faker.address().streetName())
                .setNumber(Integer.valueOf(faker.address().streetAddressNumber()))
                .setNeighborhood(faker.name().fullName())
                .setState(faker.address().state())
                .setPerson(person);
    }
}
