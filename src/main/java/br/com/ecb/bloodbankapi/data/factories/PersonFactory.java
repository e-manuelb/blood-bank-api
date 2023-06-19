package br.com.ecb.bloodbankapi.data.factories;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class PersonFactory {

    public Person create() {
        Faker faker = new Faker(new Locale("pt-BR"));

        return new Person()
                .setName(faker.name().fullName())
                .setEmail(faker.internet().emailAddress())
                .setDateOfBirth(LocalDate.parse(new SimpleDateFormat("dd/MM/yyyy").format(faker.date().birthday()), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .setPhone(faker.phoneNumber().cellPhone())
                .setLandline(faker.phoneNumber().phoneNumber());
    }
}
