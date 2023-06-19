package br.com.ecb.bloodbankapi.domain.features.person;

import br.com.ecb.bloodbankapi.domain.models.person.Person;

public interface GetPersonByEmail {
    Person handle(String email);
}
