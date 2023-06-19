package br.com.ecb.bloodbankapi.domain.features.person;

import br.com.ecb.bloodbankapi.domain.models.person.Person;

import java.util.List;

public interface ListPersons {
    List<Person> handle();
}
